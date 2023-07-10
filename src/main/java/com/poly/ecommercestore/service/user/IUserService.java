package com.poly.ecommercestore.service.user;

import com.poly.ecommercestore.entity.Accounts;
import com.poly.ecommercestore.DTO.client.AccountDTO;
import com.poly.ecommercestore.DTO.client.UserDTO;

public interface IUserService {

    public Object updateUser(UserDTO user);

    public Accounts updatePassword(AccountDTO account);
}
