package com.poly.ecommercestore.entity;

import lombok.*;

import jakarta.persistence.*;

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


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCategory")
    private Categories category;

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
