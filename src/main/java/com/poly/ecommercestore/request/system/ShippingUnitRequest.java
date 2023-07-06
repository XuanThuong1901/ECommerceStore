package com.poly.ecommercestore.request.system;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShippingUnitRequest {

    private String shippingUnitName;

    private String email;

    private String telephone;

    private String address;

    private BigDecimal shippingCost;

    public ShippingUnitRequest() {
    }

    public ShippingUnitRequest(String shippingUnitName, String email, String telephone, String address, BigDecimal shippingCost) {
        this.shippingUnitName = shippingUnitName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.shippingCost = shippingCost;
    }

}
