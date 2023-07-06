package com.poly.ecommercestore.service.order;

import com.poly.ecommercestore.entity.Orders;
import com.poly.ecommercestore.repository.*;
import com.poly.ecommercestore.request.client.OrderCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

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

    @Override
    public List<Orders> getOrderByCustomer(String iDCustomer) {
        return null;
    }

    @Override
    public List<Orders> getAllOrder() {
        return null;
    }

    @Override
    public Orders addOrder(OrderCustomerRequest orderCustomerRequest) {
        return null;
    }

    @Override
    public Boolean statusConfirmedOrder(int iDOrder) {
        return null;
    }

    @Override
    public Boolean statusDeliveryOrder(int iDOrder) {
        return null;
    }

    @Override
    public Boolean statusDeliveredOrder(int iDOrder) {
        return null;
    }

    @Override
    public Boolean statusCanceledOrder(int iDOrder) {
        return null;
    }
}
