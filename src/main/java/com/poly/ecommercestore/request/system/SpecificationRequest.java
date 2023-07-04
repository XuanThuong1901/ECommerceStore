package com.poly.ecommercestore.request.system;

import lombok.Data;

@Data
public class SpecificationRequest {

    private String specificationName;
    private String parameter;

    public SpecificationRequest() {
    }

    public SpecificationRequest(String specificationName, String parameter) {
        this.specificationName = specificationName;
        this.parameter = parameter;
    }
}
