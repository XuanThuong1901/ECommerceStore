package com.poly.ecommercestore.service.order;

import com.poly.ecommercestore.entity.*;
import com.poly.ecommercestore.entity.embeddable.DetailOrderId;
import com.poly.ecommercestore.repository.*;
import com.poly.ecommercestore.request.client.DetailOrderRequest;
import com.poly.ecommercestore.request.client.OrderRequest;
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
    private StatusOrderRepository statusOrderRepository;

    @Autowired
    private ShippingUnitRepository shippingUnitRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductRepository productRepository;

    private final int UNCONFIRMED = 1;
    private final int CONFIRMED = 2;
    private final int DELIVERY = 3;
    private final int DELIVERED = 4;
    private final int CANCELED = 5;

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
    public Orders addOrder(OrderRequest orderCustomer, String idCustomer) {

        if(orderCustomer.getDetailOrders().size() == 0)
            return null;

        Customers customer = customerRepository.getCustomersById(idCustomer);
        ShippingUnits shippingUnit = shippingUnitRepository.getReferenceById(orderCustomer.getShippingUnit());
        Payments payment = paymentRepository.getReferenceById(orderCustomer.getPayment());
        StatusOrders statusOrder = statusOrderRepository.getReferenceById(UNCONFIRMED);

        if(customer == null || shippingUnit == null || payment == null || statusOrder == null)
            return null;

        Orders newOrder = new Orders();

        newOrder.setAddress(orderCustomer.getAddress());
        newOrder.setTelephone(orderCustomer.getTelephone());
        newOrder.setNote(orderCustomer.getNote());
        newOrder.setCustomer(customer);
        newOrder.setShippingUnit(shippingUnit);
        newOrder.setPayment(payment);
        newOrder.setStatusOrder(statusOrder);

        newOrder = orderRepository.save(newOrder);

        List<DetailOrders> newDetailOrders = new ArrayList<>();
        BigDecimal price = shippingUnit.getShippingCost();

        for(DetailOrderRequest detailOrder : orderCustomer.getDetailOrders()){

            Products product = productRepository.getReferenceById(detailOrder.getProduct());
            if(product == null || product.getQuantity() < detailOrder.getQuantity())
                return null;

            DetailOrderId detailOrderId = new DetailOrderId(newOrder.getIDOrder(), product.getIDProduct());
            DetailOrders detailOrderTemp = new DetailOrders(detailOrderId, detailOrder.getQuantity(), newOrder, product);

            newDetailOrders.add(detailOrderTemp);
            price = price.add((product.getPrice().multiply(BigDecimal.valueOf(detailOrder.getQuantity()))));
            product.setQuantity(product.getQuantity() - detailOrder.getQuantity());
        }

        newOrder.setDetailOrders(newDetailOrders);
        newOrder.setPrice(price);

        detailOrderRepository.saveAll(newDetailOrders);
        orderRepository.save(newOrder);

        return newOrder;
    }

    @Override
    public Boolean statusConfirmedOrder(int iDOrder) {

        Orders order = orderRepository.getReferenceById(iDOrder);
        if(order == null)
            return false;

        if(order.getStatusOrder().getIDStatusOrder() == UNCONFIRMED){
            order.setStatusOrder(statusOrderRepository.getReferenceById(CONFIRMED));
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

        if(order.getStatusOrder().getIDStatusOrder() == CONFIRMED){
            order.setStatusOrder(statusOrderRepository.getReferenceById(DELIVERY));
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

        if(order.getStatusOrder().getIDStatusOrder() == DELIVERY){
            order.setStatusOrder(statusOrderRepository.getReferenceById(DELIVERED));
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

        if(order.getStatusOrder().getIDStatusOrder() == UNCONFIRMED ||order.getStatusOrder().getIDStatusOrder() == CONFIRMED){
            order.setStatusOrder(statusOrderRepository.getReferenceById(CANCELED));
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
}
