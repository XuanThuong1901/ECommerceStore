package com.poly.ecommercestore.DTO.client;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {

    private String address;
    private String telephone;
    private String note;
    private Integer shippingUnit;
    private Integer payment;
    private List<DetailOrderDTO> detailOrders;

    public OrderDTO() {
    }

    public OrderDTO(String address, String telephone, String note, Integer shippingUnit, Integer payment, List<DetailOrderDTO> detailOrders) {
        this.address = address;
        this.telephone = telephone;
        this.note = (note != null) ? note : "N/A";
        this.shippingUnit = shippingUnit;
        this.payment = payment;
        this.detailOrders = (detailOrders != null) ? new ArrayList<>() : null;
    }
}
