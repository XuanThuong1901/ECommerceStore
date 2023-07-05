package com.poly.ecommercestore.request.system;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poly.ecommercestore.entity.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

public class OderEmployerRequest {

    private BigDecimal price;
    private String address;
    private String telephone;
    private String note;
    private Customers customer;
    private Employers employer;
    private ShippingUnits shippingUnit;
    private Payments payment;
    private StatusOrders statusOrder;
    private List<DetailOrders> detailOrders;
}
