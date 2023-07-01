package com.poly.ecommercestore.controller;

import com.poly.ecommercestore.entity.Status;
import com.poly.ecommercestore.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusController {

    @Autowired
    private StatusService statusService;
    @GetMapping("/test")
    public ResponseEntity<?> get(){
        System.out.println("in ra");
        List<Status> list = statusService.getAllStatus();
        list.forEach(System.out :: println);
        return ResponseEntity.ok(list);
    }


}
