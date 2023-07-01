package com.poly.ecommercestore.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    private String email;
    private String password;
    private String name;
    private Date birthday;
    private String address;
    private boolean gender;
    private String telephone;
    private String identityCard;
    private String avatar;
    private int position;

    public UserDTO(String email, String password, String name, String address, String telephone, int position) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.position = position;
    }

    public UserDTO(String email, String password, String name, Date birthday, String address, boolean gender, String telephone, String identityCard, String avatar, int position) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.telephone = telephone;
        this.identityCard = identityCard;
        this.avatar = avatar;
        this.position = position;
    }
}
