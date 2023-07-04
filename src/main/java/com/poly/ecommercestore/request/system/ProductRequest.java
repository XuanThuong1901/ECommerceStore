package com.poly.ecommercestore.request.system;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductRequest {

    private String productName;
    private Integer detailCategory;
    private Integer supplier;
    private Integer quantity;
    private BigDecimal price;
    private String feature;
    private String contents;
    private String guarantee;
    private List<ImageProductRequest> imageProduct;
    private List<SpecificationRequest> specification;

    public ProductRequest() {
    }

    public ProductRequest(Integer detailCategory, Integer supplier, String productName, Integer quantity, BigDecimal price, String feature, String contents, List<ImageProductRequest> imageProduct, List<SpecificationRequest> specification) {
        this.productName = productName;
        this.detailCategory = (detailCategory == null) ? detailCategory : 0;
        this.supplier = (supplier == null) ? supplier : 0;
        this.quantity = (quantity == null) ? quantity : 0;
        this.price = price;
        this.feature = (feature != null) ? feature : "N/A";
        this.contents = (contents != null) ? contents : "N/A";
        this.guarantee = (guarantee != null) ? guarantee : "N/A";
        this.imageProduct = (imageProduct != null) ? imageProduct : new ArrayList<>();
        this.specification = (specification != null) ? specification : new ArrayList<>();
    }


}

