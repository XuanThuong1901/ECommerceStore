package com.poly.ecommercestore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Employers")
public class Employers {

    @Id
    @Column(name = "IDEmployer")
    private String iDEmployer;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "IDEmployer")
    private Accounts account;

    @Column(name = "Name")
    private String name;

    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "Gender")
    private boolean gender;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "IdentityCard")
    private String identityCard;

    @Column(name = "Avatar")
    private String avatar;


    @OneToMany(mappedBy = "employer")
    private List<Orders> orders;

    @OneToMany(mappedBy = "employer")
    private List<ImportStocks> importStocks;

    @OneToMany(mappedBy = "employer")
    private List<ExportStocks> exportStocks;

    public Employers() {
    }

    public Employers(String iDEmployer, Accounts account, String name, Date birthday, boolean gender, String telephone, String identityCard, String avatar) {
        this.iDEmployer = iDEmployer;
        this.account = account;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.telephone = telephone;
        this.identityCard = identityCard;
        this.avatar = avatar;
    }

    public Employers(String iDEmployer, Accounts account, String name, Date birthday, boolean gender, String telephone, String identityCard, String avatar, List<Orders> orders, List<ImportStocks> importStocks, List<ExportStocks> exportStocks) {
        this.iDEmployer = iDEmployer;
        this.account = account;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.telephone = telephone;
        this.identityCard = identityCard;
        this.avatar = avatar;
        this.orders = orders;
        this.importStocks = importStocks;
        this.exportStocks = exportStocks;
    }
}
