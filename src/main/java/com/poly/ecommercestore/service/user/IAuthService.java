package com.poly.ecommercestore.service.user;

import com.poly.ecommercestore.entity.Accounts;
import com.poly.ecommercestore.DTO.client.UserDTO;

public interface IAuthService {

    public Accounts createUser(UserDTO user, String permission);

    public Accounts getAccountByLogin(String email, String password);

}
