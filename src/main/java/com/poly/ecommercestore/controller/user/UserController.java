package com.poly.ecommercestore.controller.user;

import com.poly.ecommercestore.repository.AccountRepository;
import com.poly.ecommercestore.repository.EmployerRepository;
import com.poly.ecommercestore.DTO.client.AccountDTO;
import com.poly.ecommercestore.DTO.client.UserDTO;
import com.poly.ecommercestore.service.shared.ECommerceMessage;
import com.poly.ecommercestore.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private IUserService userService;


    @GetMapping("/select/{id}")
    public ResponseEntity<?> getUser(@PathVariable(value = "id") String id){
        return ResponseEntity.ok(employerRepository.getReferenceById(id));
    }

    @PostMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(UserDTO user, @PathVariable(value = "id") String iDUser){
        if(accountRepository.getById(iDUser) != null){
            userService.updateUser(user);
            return ResponseEntity.badRequest().body(ECommerceMessage.USER_SUCCESSFUL);
        }

        return ResponseEntity.badRequest().body(ECommerceMessage.USER_NOT_FOUND);
    }

    @PostMapping("updatePassword/{email}")
    public ResponseEntity<String> updatePass(AccountDTO account, @PathVariable(value = "email") String email){
        if(accountRepository.getByEmail(email) != null){
            userService.updatePassword(account);
            return ResponseEntity.badRequest().body(ECommerceMessage.ACOUNT_SUCCESSFUL);
        }

        return ResponseEntity.badRequest().body(ECommerceMessage.ACCOUNT_NOT_FOUND);
    }
}
