package com.poly.ecommercestore.service.user;

import com.poly.ecommercestore.entity.Accounts;
import com.poly.ecommercestore.request.AccountRequest;
import com.poly.ecommercestore.request.UserRequest;

public interface IUserService {

    public Object updateUser(UserRequest user);

    public Accounts updatePassword(AccountRequest account);
}
