package com.poly.ecommercestore.controller.user;

import com.poly.ecommercestore.entity.Accounts;
import com.poly.ecommercestore.repository.AccountRepository;
import com.poly.ecommercestore.request.AccountRequest;
import com.poly.ecommercestore.request.UserRequest;
import com.poly.ecommercestore.service.user.AuthService;
import com.poly.ecommercestore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthService authService;

    @PostMapping("/register/{permission}")
    public ResponseEntity<String> register(UserRequest user, @PathVariable(value = "permission") String permission){
        if(accountRepository.getByEmail(user.getEmail()) != null){
            return ResponseEntity.badRequest().body("Email already in use.");
        }

        System.out.println(permission);
        authService.createUser(user, permission);
        return ResponseEntity.ok("User created successfully.");
    }

    @PostMapping("/login")
    public Accounts login(AccountRequest loginRequest){
        try {
            Accounts account = authService.getAccountByLogin(loginRequest.getEmail(), loginRequest.getPassword());
            if(account != null)
                return account;
            return null;
        }
        catch (Exception e){
            return null;
        }
    }
}
