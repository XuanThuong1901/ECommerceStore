package com.poly.ecommercestore.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @JsonIgnoreProperties("category")
    @Fetch(FetchMode.JOIN)
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
