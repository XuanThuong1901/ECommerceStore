package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@Table(name = "Positions")
public class Positions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPosition")
    private int iDPosition;

    @Column(name = "Position")
    private String position;

    @JsonIgnore
    @OneToMany(mappedBy = "position")
    private List<Accounts> accounts;

    public Positions() {
    }

    public Positions(String position) {
        this.position = position;
    }

    public Positions(String position, List<Accounts> accounts) {
        this.position = position;
        this.accounts = accounts;
    }
}
