package com.poly.ecommercestore.entity;



import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCategory")
    private int iDCategory;

    @Column(name = "CategoryName")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<DetailCategories> detailCategories;

    public Categories() {
    }

    public Categories(String categoryName) {
        this.categoryName = categoryName;
    }

    public Categories(String categoryName, List<DetailCategories> detailCategories) {
        this.categoryName = categoryName;
        this.detailCategories = detailCategories;
    }
}
