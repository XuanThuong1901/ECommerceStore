package com.poly.ecommercestore.request;

import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {

    private String email;
    private String password;
    private String name;
    private Date birthday;
    private String address;
    private Boolean gender;
    private String telephone;
    private String identityCard;
    private String avatar;
    private int position;

//    public UserRequest(String email, String password, String name, String address, String telephone, int position) {
//        this.email = email;
//        this.password = password;
//        this.name = name;
//        this.address = address;
//        this.telephone = telephone;
//        this.position = position;
//    }

    public UserRequest(String email, String password, String name, Date birthday, String address, Boolean gender, String telephone, String identityCard, String avatar, int position) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthday = (birthday != null) ? birthday : null;
        this.address = address;
        this.gender = (gender != null) ? gender : false;
        this.telephone = (telephone != null) ? telephone : "N/A";
        this.identityCard = (identityCard != null) ? identityCard : "N/A";
        this.avatar = (avatar != null) ? avatar : "N/A";
        this.position = position;
    }
}
