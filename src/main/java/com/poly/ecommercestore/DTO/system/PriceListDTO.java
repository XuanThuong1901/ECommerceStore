package com.poly.ecommercestore.DTO.system;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PriceListDTO {

    private String type;
    private Date applicableDate;
    private BigDecimal price;

    public PriceListDTO() {
    }

    public PriceListDTO(String type, Date applicableDate, BigDecimal price) {
        this.type = type;
        this.applicableDate = applicableDate;
        this.price = price;
    }
}
