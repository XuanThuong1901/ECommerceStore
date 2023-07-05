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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDStatus")
    private int iDStatus;

    @Column(name = "StatusName")
    private String statusName;

    @JsonIgnore
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
