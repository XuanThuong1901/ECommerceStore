package com.poly.ecommercestore.service.order;

import com.poly.ecommercestore.entity.Orders;
import com.poly.ecommercestore.request.client.OrderRequest;

import java.util.List;

public interface IOrderService {

    Orders getOneOrder(int iDOrder);

    List<Orders> getOrderByCustomer(String iDCustomer);

    List<Orders> getAllOrder();

    Orders addOrder(OrderRequest orderCustomerRequest, String iDCustomer);

    Boolean statusConfirmedOrder(int iDOrder);

    Boolean statusDeliveryOrder(int iDOrder);

    Boolean statusDeliveredOrder(int iDOrder);

    Boolean statusCanceledOrder(int iDOrder);
}
