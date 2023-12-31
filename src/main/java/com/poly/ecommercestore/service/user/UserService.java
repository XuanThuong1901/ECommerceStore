package com.poly.ecommercestore.service.user;

import com.poly.ecommercestore.entity.*;
import com.poly.ecommercestore.repository.*;
import com.poly.ecommercestore.DTO.client.AccountDTO;
import com.poly.ecommercestore.DTO.client.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements  IUserService{

    @Autowired
    private AccountRepository accountRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public Object updateUser(UserDTO user) {

        String keyId = user.getUserId().substring(0,3);

        if(keyId.equals("CUS")){
            Customers updateCus = customerRepository.getCustomersById(user.getUserId());
            updateCus.setName(user.getName());
            updateCus.setAddress(user.getAddress());
            updateCus.setTelephone(user.getTelephone());

            customerRepository.save(updateCus);

            return updateCus;
        }
        else if(keyId.equals("EMP")) {
            Employers updateEmp = employerRepository.getEmployersById(user.getUserId());
            updateEmp.setName(user.getName());
            updateEmp.setAddress(user.getAddress());
            updateEmp.setTelephone(user.getTelephone());
            updateEmp.setBirthday(user.getBirthday());
            updateEmp.setAvatar(user.getAvatar());
            updateEmp.setGender(user.getGender());
            updateEmp.setIdentityCard(user.getIdentityCard());

            employerRepository.save(updateEmp);

            return updateEmp;
        }
        return null;
    }

    @Override
    public Accounts updatePassword(AccountDTO account) {
        Accounts updateAccount = accountRepository.getByEmail(account.getEmail());
        if(updateAccount != null){
            updateAccount.setPassword(account.getPassword());
            accountRepository.save(updateAccount);
            return updateAccount;
        }
        return null;
    }
}
