package com.poly.ecommercestore.DTO.system;

import lombok.Data;

@Data
public class SpecificationDTO {

    private String specificationName;
    private String parameter;

    public SpecificationDTO() {
    }

    public SpecificationDTO(String specificationName, String parameter) {
        this.specificationName = specificationName;
        this.parameter = parameter;
    }
}
