package com.poly.ecommercestore.entity;

import lombok.*;
import jakarta.persistence.*;
@Data
@Entity
@Table(name = "Accounts")
public class Accounts {
    @Id
    @Column(name = "IDAccount", nullable = false)
    private String iDAccount;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private Employers employer;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private Customers customers;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDStatus")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDPosition")
    private Positions position;

    public Accounts() {
    }

    public Accounts(String iDAccount, String email, String password, Employers employer, Customers customers, Status status, Positions position) {
        this.iDAccount = iDAccount;
        this.email = email;
        this.password = password;
        this.employer = employer;
        this.customers = customers;
        this.status = status;
        this.position = position;
    }
}
