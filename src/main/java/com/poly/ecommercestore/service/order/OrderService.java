package com.poly.ecommercestore.service.order;

import com.poly.ecommercestore.entity.*;
import com.poly.ecommercestore.entity.embeddable.DetailOrderId;
import com.poly.ecommercestore.repository.*;
import com.poly.ecommercestore.DTO.client.DetailOrderDTO;
import com.poly.ecommercestore.DTO.client.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DetailOrderRepository detailOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ShippingUnitRepository shippingUnitRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TaxRepository taxRepository;

    private final int UNCONFIRMED = 1;
    private final int CONFIRMED = 2;
    private final int DELIVERY = 3;
    private final int DELIVERED = 4;
    private final int CANCELED = 5;

    private final int ONE_HUNDRED = 100;

    private final String HANOI = "Hà Nội";
    private final String DANANG = "Đà Nẵng";
    private final String TPHCM = "Hồ Chí Minh";
    private final String EXPORT = "EXPORT";

    @Override
    public Orders getOneOrder(int iDOrder) {
        return orderRepository.getReferenceById(iDOrder);
    }

    @Override
    public List<Orders> getOrderByCustomer(String iDCustomer) {
        return null;
    }

    @Override
    public List<Orders> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Orders addOrder(OrderDTO order, String idCustomer) {

        if(order.getDetailOrders().size() == 0)
            return null;

        Customers customer = customerRepository.getCustomersById(idCustomer);
        ShippingUnits shippingUnit = shippingUnitRepository.getReferenceById(order.getShippingUnit());
        Payments payment = paymentRepository.getReferenceById(order.getPayment());
        Status status = statusRepository.getReferenceById(UNCONFIRMED);

        if(customer == null || shippingUnit == null || payment == null || status == null)
            return null;

        Orders newOrder = new Orders();

        newOrder.setAddress(order.getAddress());
        newOrder.setTelephone(order.getTelephone());
        newOrder.setNote(order.getNote());
        newOrder.setCustomer(customer);
        newOrder.setShippingUnit(shippingUnit);
        newOrder.setPayment(payment);
        newOrder.setStatus(status);

        if(checkAddressShipping(order.getAddress())){
            newOrder.setShippingFee(new BigDecimal(20000));
        }
        else {
            newOrder.setShippingFee(new BigDecimal(30000));
        }

        newOrder = orderRepository.save(newOrder);

        List<DetailOrders> newDetailOrders = new ArrayList<>();
        BigDecimal amount = new BigDecimal(0);
        BigDecimal taxAmount = new BigDecimal(0);

        for(DetailOrderDTO detailOrder : order.getDetailOrders()){

            Products product = productRepository.getReferenceById(detailOrder.getProduct());
            if(product == null || product.getQuantity() < detailOrder.getQuantity())
                return null;

            BigDecimal priceProduct = new BigDecimal(0);
            for (PriceLists priceList : product.getPriceLists()){
                if(priceList.getStatus() && priceList.getType().equals(EXPORT)){
                    priceProduct = priceList.getPrice();
                }
            }

            BigDecimal lineAmount = priceProduct.multiply(BigDecimal.valueOf(detailOrder.getQuantity())).add(countTax(priceProduct, product.getTax().getTaxPercentage()));
            taxAmount = taxAmount.add(lineAmount);

            DetailOrderId detailOrderId = new DetailOrderId(newOrder.getIDOrder(), product.getIDProduct());
            DetailOrders detailOrderTemp = new DetailOrders(detailOrderId, detailOrder.getQuantity(), priceProduct, lineAmount, newOrder, product, product.getTax());



            newDetailOrders.add(detailOrderTemp);
            amount = amount.add((priceProduct.multiply(BigDecimal.valueOf(detailOrder.getQuantity()))));
            product.setQuantity(product.getQuantity() - detailOrder.getQuantity());

        }



        newOrder.setDetailOrders(newDetailOrders);
        newOrder.setAmount(amount);
        newOrder.setTaxAmount(taxAmount);

        detailOrderRepository.saveAll(newDetailOrders);
        orderRepository.save(newOrder);

        return newOrder;
    }

    @Override
    public Boolean statusConfirmedOrder(int iDOrder) {

        Orders order = orderRepository.getReferenceById(iDOrder);
        if(order == null)
            return false;

        if(order.getStatus().getIDStatus() == UNCONFIRMED){
            order.setStatus(statusRepository.getReferenceById(CONFIRMED));
            orderRepository.save(order);

            return true;
        }

        return false;
    }

    @Override
    public Boolean statusDeliveryOrder(int iDOrder) {

        Orders order = orderRepository.getReferenceById(iDOrder);
        if(order == null)
            return false;

        if(order.getStatus().getIDStatus() == CONFIRMED){
            order.setStatus(statusRepository.getReferenceById(DELIVERY));
            orderRepository.save(order);

            return true;
        }

        return false;
    }

    @Override
    public Boolean statusDeliveredOrder(int iDOrder) {

        Orders order = orderRepository.getReferenceById(iDOrder);
        if(order == null)
            return false;

        if(order.getStatus().getIDStatus() == DELIVERY){
            order.setStatus(statusRepository.getReferenceById(DELIVERED));
            orderRepository.save(order);

            return true;
        }

        return false;
    }

    @Override
    public Boolean statusCanceledOrder(int iDOrder) {

        Orders order = orderRepository.getReferenceById(iDOrder);
        if(order == null)
            return false;

        if(order.getStatus().getIDStatus() == UNCONFIRMED ||order.getStatus().getIDStatus() == CONFIRMED){
            order.setStatus(statusRepository.getReferenceById(CANCELED));
            orderRepository.save(order);

            for (DetailOrders detailOrder : order.getDetailOrders()){

                Products product = detailOrder.getProduct();
                product.setQuantity(product.getQuantity() + detailOrder.getQuantity());

                productRepository.save(product);
            }
            return true;
        }

        return false;
    }

    private Boolean checkAddressShipping(String address){
        if(address.contains(HANOI))
            return true;
        if(address.contains(DANANG))
            return true;
        if(address.contains(TPHCM))
            return true;

        return false;
    }

    private BigDecimal countTax(BigDecimal price, int taxPercentage){
        return price.multiply(BigDecimal.valueOf(taxPercentage/ONE_HUNDRED));
    }
}
