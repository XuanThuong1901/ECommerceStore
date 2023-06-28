package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;

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
