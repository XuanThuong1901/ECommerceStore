package com.poly.ecommercestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @JsonIgnoreProperties("account")
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private Employers employer;

    @JsonIgnoreProperties("account")
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private Customers customers;

    @JsonIgnoreProperties("accounts")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "IDStatus")
    private Status status;

    @JsonIgnoreProperties("accounts")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "IDRole")
    private Roles role;

    public Accounts() {
    }

    public Accounts(String iDAccount, String email, String password, Employers employer, Customers customers, Status status, Roles role) {
        this.iDAccount = iDAccount;
        this.email = email;
        this.password = password;
        this.employer = employer;
        this.customers = customers;
        this.status = status;
        this.role = role;
    }
}
