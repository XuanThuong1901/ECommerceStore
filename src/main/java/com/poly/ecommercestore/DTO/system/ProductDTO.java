package com.poly.ecommercestore.DTO.system;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {

    private String productName;
    private Integer category;
    private Integer supplier;
    private Integer quantity;
    private String feature;
    private String contents;
    private String guarantee;
    private List<PriceListDTO> priceListDTOS;
    private List<ImageProductDTO> imageProduct;
    private List<SpecificationDTO> specification;

    public ProductDTO() {
    }

    public ProductDTO(Integer category, Integer supplier, String productName, Integer quantity, String feature, String contents, List<PriceListDTO> priceListDTOS, List<ImageProductDTO> imageProduct, List<SpecificationDTO> specification) {
        this.productName = productName;
        this.category = (category == null) ? category : 0;
        this.supplier = (supplier == null) ? supplier : 0;
        this.quantity = (quantity == null) ? quantity : 0;
        this.feature = (feature != null) ? feature : "N/A";
        this.contents = (contents != null) ? contents : "N/A";
        this.guarantee = (guarantee != null) ? guarantee : "N/A";
        this.priceListDTOS = (priceListDTOS != null) ? priceListDTOS : new ArrayList<>();
        this.imageProduct = (imageProduct != null) ? imageProduct : new ArrayList<>();
        this.specification = (specification != null) ? specification : new ArrayList<>();
    }


}

