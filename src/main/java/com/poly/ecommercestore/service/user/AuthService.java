package com.poly.ecommercestore.service.user;

import com.poly.ecommercestore.entity.*;
import com.poly.ecommercestore.repository.*;
import com.poly.ecommercestore.request.client.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService implements IAuthService{

    @Autowired
    private AccountRepository accountRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployerRepository employerRepository;

    private static final int lengthID = 10;
    private static final int iDStatus = 1;

    @Override
    public Accounts createUser(UserRequest user, String permission) {
        Accounts newAccount = new Accounts();
        Status status = statusRepository.getStatusById(iDStatus);
        Positions position = positionRepository.getPositionById(user.getPosition());
//        String encoderPassword = passwordEncoder.encode(user.getPassword());

        newAccount.setEmail(user.getEmail());
        newAccount.setPassword(user.getPassword());
        newAccount.setStatus(status);
        newAccount.setPosition(position);
        if(permission.equals("customer")){
            String newID = "CUS" + generateRandomString();
            newAccount.setIDAccount(newID);


            Customers newCustomer = new Customers(newID, newAccount, user.getName(), user.getAddress(), user.getTelephone());

            newAccount.setCustomers(newCustomer);
            this.accountRepository.save(newAccount);
            this.customerRepository.save(newCustomer);
        }
        else if(permission.equals("employer")){
            String newID = "EMP" + generateRandomString();
            newAccount.setIDAccount(newID);

            Employers newEmployer = new Employers(newID, newAccount,user.getName(), user.getAddress(), user.getBirthday(), user.getGender(), user.getTelephone(), user.getIdentityCard(), user.getAvatar());


            newAccount.setEmployer(newEmployer);
            this.accountRepository.save(newAccount);
            this.employerRepository.save(newEmployer);
        }

        return newAccount;
    }

    @Override
    public Accounts getAccountByLogin(String email, String password) {
        //        String encoderPassword = passwordEncoder.encode(password);
        return accountRepository.findByLogin(email, password);
    }

    public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lengthID; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
