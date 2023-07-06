package com.poly.ecommercestore.request.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poly.ecommercestore.entity.*;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderRequest {

    private String address;
    private String telephone;
    private String note;
    private Integer shippingUnit;
    private Integer payment;
    private List<DetailOrderRequest> detailOrders;

    public OrderRequest() {
    }

    public OrderRequest(String address, String telephone, String note, Integer shippingUnit, Integer payment, List<DetailOrderRequest> detailOrders) {
        this.address = address;
        this.telephone = telephone;
        this.note = (note != null) ? note : "N/A";
        this.shippingUnit = shippingUnit;
        this.payment = payment;
        this.detailOrders = (detailOrders != null) ? new ArrayList<>() : null;
    }
}
