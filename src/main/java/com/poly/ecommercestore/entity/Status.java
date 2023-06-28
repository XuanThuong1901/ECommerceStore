package com.poly.ecommercestore.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDStatus")
    private int iDStatus;

    @Column(name = "StatusName")
    private String statusName;

    @OneToMany(mappedBy = "status")
    private List<Accounts> accounts;

    public Status() {
    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public Status(String statusName, List<Accounts> accounts) {
        this.statusName = statusName;
        this.accounts = accounts;
    }
}
