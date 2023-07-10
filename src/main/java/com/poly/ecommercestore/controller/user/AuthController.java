package com.poly.ecommercestore.controller.user;

import com.poly.ecommercestore.entity.Accounts;
import com.poly.ecommercestore.repository.AccountRepository;
import com.poly.ecommercestore.DTO.client.AccountDTO;
import com.poly.ecommercestore.DTO.client.UserDTO;
import com.poly.ecommercestore.service.user.AuthService;
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
    public ResponseEntity<String> register(UserDTO user, @PathVariable(value = "permission") String permission){
        if(accountRepository.getByEmail(user.getEmail()) != null){
            return ResponseEntity.badRequest().body("Email already in use.");
        }

        System.out.println(permission);
        authService.createUser(user, permission);
        return ResponseEntity.ok("User created successfully.");
    }

    @PostMapping("/login")
    public Accounts login(AccountDTO loginRequest){
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
