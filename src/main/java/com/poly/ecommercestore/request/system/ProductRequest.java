package com.poly.ecommercestore.request.system;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRequest {

    private int iDDetailCategory;
    private int iDSupplier;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private String feature;
    private String contents;
    private String guarantee;
    private String expiry;
    private List<ImageProductRequest> imageProduct;
    private List<SpecificationRequest> specification;


    public ProductRequest( int iDDetailCategory, int iDSupplier, String productName, int quantity, BigDecimal price, String feature, String contents, String guarantee, String expiry, List<ImageProductRequest> imageProduct, List<SpecificationRequest> specification) {
        this.productName = productName;
        this.iDDetailCategory = iDDetailCategory;
        this.iDSupplier = iDSupplier;
        this.quantity = quantity;
        this.price = price;
        this.feature = (feature != null) ? feature : "N/A";
        this.contents = (contents != null) ? contents : "N/A";
        this.guarantee = (guarantee != null) ? guarantee : "N/A";
        this.expiry = (expiry != null) ? expiry : "N/A";
        this.imageProduct = imageProduct;
        this.specification = specification;
    }
}

