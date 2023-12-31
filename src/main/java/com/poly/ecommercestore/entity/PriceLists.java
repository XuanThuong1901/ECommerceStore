package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Tax")
public class PriceLists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPrice")
    private int iDPrice;

    @Column(name = "UpdateDate")
    private Date updateDate;

    @Column(name = "Type")
    private String type;

    @Column(name = "ApplicableDate")
    private Date applicableDate;

    @Column(name = "Price", unique = true)
    private BigDecimal price;

    @Column(name = "Status")
    private Boolean status;

    @JsonIgnoreProperties("priceLists")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDEmployer")
    private Employers employer;

    @JsonIgnoreProperties("ProductPrices")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDProduct")
    private Products product;

    public PriceLists() {
    }

    public PriceLists(Date updateDate, String type, Date applicableDate, BigDecimal price, Employers employer, Products product) {
        this.updateDate = updateDate;
        this.type = type;
        this.applicableDate = applicableDate;
        this.price = price;
        this.employer = employer;
        this.product = product;
    }
}
