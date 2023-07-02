package com.poly.ecommercestore.service.user;

import com.poly.ecommercestore.entity.Accounts;
import com.poly.ecommercestore.request.UserRequest;

public interface IAuthService {

    public Accounts createUser(UserRequest user, String permission);

    public Accounts getAccountByLogin(String email, String password);

}
