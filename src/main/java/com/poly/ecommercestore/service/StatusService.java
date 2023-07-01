package com.poly.ecommercestore.service;

import com.poly.ecommercestore.entity.Status;
import com.poly.ecommercestore.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService{

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }
}
