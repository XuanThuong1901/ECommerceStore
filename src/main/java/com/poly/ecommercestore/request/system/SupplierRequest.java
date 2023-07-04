package com.poly.ecommercestore.request.system;

import lombok.Data;

@Data
public class SupplierRequest {

    private String supplierName;

    private String email;

    private String telephone;

    private String address;

    public SupplierRequest() {
    }

    public SupplierRequest(String supplierName, String email, String telephone, String address) {
        this.supplierName = supplierName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }
}
