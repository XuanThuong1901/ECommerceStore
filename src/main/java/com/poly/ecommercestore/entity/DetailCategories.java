package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@Table(name = "DetailCategories")
public class DetailCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDetailCategory")
    private int iDDetailCategory;

    @Column(name = "DetailCategoryName")
    private String detailCategoryName;


    @JsonIgnoreProperties("detailCategories")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCategory")
    private Categories category;

    @JsonIgnore()
    @OneToMany(mappedBy = "detailCategory")
    private List<Products> products;

    public DetailCategories() {
    }

    public DetailCategories(String detailCategoryName, Categories category) {
        this.detailCategoryName = detailCategoryName;
        this.category = category;
    }

    public DetailCategories(String detailCategoryName, Categories category, List<Products> products) {
        this.detailCategoryName = detailCategoryName;
        this.category = category;
        this.products = products;
    }
}
