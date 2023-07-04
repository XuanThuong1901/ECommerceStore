package com.poly.ecommercestore.controller.system;

import com.poly.ecommercestore.request.system.SupplierRequest;
import com.poly.ecommercestore.service.shared.ECommerceMessage;
import com.poly.ecommercestore.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/")
    public ResponseEntity<?> getAllSupplier(){
        return ResponseEntity.ok(supplierService.getAllSupplier());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSupplier(@RequestBody SupplierRequest supplier){
        if(supplier.getSupplierName() == null){
            return ResponseEntity.badRequest().body("Supplier not name");
        }
        if(supplier.getEmail() == null){
            return ResponseEntity.badRequest().body("Supplier not email");
        }
        if(supplier.getTelephone() == null){
            return ResponseEntity.badRequest().body("Supplier not telephone");
        }
        if(supplier.getAddress() == null){
            return ResponseEntity.badRequest().body("Supplier not address");
        }

        supplierService.addSupplier(supplier);
        return ResponseEntity.ok("Supplier added");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateSupplier(@RequestBody SupplierRequest supplier, @PathVariable(value = "id") int id){

        if(supplier.getSupplierName() == null){
            return ResponseEntity.badRequest().body("Supplier not name");
        }
        if(supplier.getEmail() == null){
            return ResponseEntity.badRequest().body("Supplier not email");
        }
        if(supplier.getTelephone() == null){
            return ResponseEntity.badRequest().body("Supplier not telephone");
        }
        if(supplier.getAddress() == null){
            return ResponseEntity.badRequest().body("Supplier not address");
        }

        if(supplierService.updateSupplier(supplier, id) == null){
            return ResponseEntity.badRequest().body(ECommerceMessage.SYSTEM_ERROR);
        }

        return ResponseEntity.ok("Supplier added");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable(value = "id") int id){
        if(supplierService.deleteSupplier(id) == false)
            return ResponseEntity.badRequest().body(ECommerceMessage.SYSTEM_ERROR);

        return ResponseEntity.ok("Supplier deleted");
    }
}
