package com.poly.ecommercestore.controller.user;

import com.poly.ecommercestore.repository.AccountRepository;
import com.poly.ecommercestore.request.client.AccountRequest;
import com.poly.ecommercestore.request.client.UserRequest;
import com.poly.ecommercestore.service.shared.ECommerceMessage;
import com.poly.ecommercestore.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private IUserService userService;

    @PostMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(UserRequest user, @PathVariable(value = "id") String iDUser){
        if(accountRepository.getById(iDUser) != null){
            userService.updateUser(user);
            return ResponseEntity.badRequest().body(ECommerceMessage.USER_SUCCESSFUL);
        }

        return ResponseEntity.badRequest().body(ECommerceMessage.USER_NOT_FOUND);
    }

    @PostMapping("updatePassword/{email}")
    public ResponseEntity<String> updatePass(AccountRequest account, @PathVariable(value = "email") String email){
        if(accountRepository.getByEmail(email) != null){
            userService.updatePassword(account);
            return ResponseEntity.badRequest().body(ECommerceMessage.ACOUNT_SUCCESSFUL);
        }

        return ResponseEntity.badRequest().body(ECommerceMessage.ACCOUNT_NOT_FOUND);
    }
}
