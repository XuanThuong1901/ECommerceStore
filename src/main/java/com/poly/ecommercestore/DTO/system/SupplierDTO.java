package com.poly.ecommercestore.DTO.system;

import lombok.Data;

@Data
public class SupplierDTO {

    private String supplierName;

    private String email;

    private String telephone;

    private String address;

    public SupplierDTO() {
    }

    public SupplierDTO(String supplierName, String email, String telephone, String address) {
        this.supplierName = supplierName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }
}
