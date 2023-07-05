package com.poly.ecommercestore.service.order;

import com.poly.ecommercestore.entity.Orders;

import java.util.List;

public interface IOrderService {

    List<Orders> getOrderByCustomer(String iDCustomer);

    List<Orders> getAllOrder();

    Orders addOrder();
}
