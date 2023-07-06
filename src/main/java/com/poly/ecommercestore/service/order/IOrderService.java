package com.poly.ecommercestore.service.order;

import com.poly.ecommercestore.entity.Orders;
import com.poly.ecommercestore.request.client.OrderCustomerRequest;

import java.util.List;

public interface IOrderService {

    List<Orders> getOrderByCustomer(String iDCustomer);

    List<Orders> getAllOrder();

    Orders addOrder(OrderCustomerRequest orderCustomerRequest);

    Boolean statusConfirmedOrder(int iDOrder);

    Boolean statusDeliveryOrder(int iDOrder);

    Boolean statusDeliveredOrder(int iDOrder);

    Boolean statusCanceledOrder(int iDOrder);
}
