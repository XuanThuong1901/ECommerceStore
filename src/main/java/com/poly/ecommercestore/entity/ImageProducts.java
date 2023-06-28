package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ImageProducts")
public class ImageProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDImgProduct")
    private int iDImgProduct;

    @Column(name = "URLImg")
    private String uRLImg;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProduct")
    private Products product;

    public ImageProducts() {
    }

    public ImageProducts(String uRLImg, Products product) {
        this.uRLImg = uRLImg;
        this.product = product;
    }
}
