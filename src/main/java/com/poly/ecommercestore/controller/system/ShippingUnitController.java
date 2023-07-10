package com.poly.ecommercestore.controller.system;

import com.poly.ecommercestore.DTO.system.ShippingUnitDTO;
import com.poly.ecommercestore.service.shared.ECommerceMessage;
import com.poly.ecommercestore.service.shippingunit.ShippingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shippingUnit")
public class ShippingUnitController {

    @Autowired
    private ShippingUnitService shippingUnitService;

    @GetMapping("/")
    public ResponseEntity<?> getAllShippingUnit(){
        return ResponseEntity.ok(shippingUnitService.getAllShippingUnit());
    }

    @PostMapping("/add")
    private ResponseEntity<?> addShippingUnit(@RequestBody ShippingUnitDTO shippingUnit){
        if(shippingUnit.getShippingUnitName() == null){
            return ResponseEntity.badRequest().body("Shipping unit not name");
        }
        if(shippingUnit.getEmail() == null){
            return ResponseEntity.badRequest().body("Shipping unit not email");
        }
        if(shippingUnit.getTelephone() == null){
            return ResponseEntity.badRequest().body("Shipping unit not telephone");
        }
        if(shippingUnit.getAddress() == null){
            return ResponseEntity.badRequest().body("Shipping unit not address");
        }
        if(shippingUnit.getShippingCost() == null){
            return ResponseEntity.badRequest().body("Shipping unit not shipping cost");
        }

        if(shippingUnitService.addShippingUnit(shippingUnit) == null)
            return ResponseEntity.badRequest().body("Name or Email or Telephone already exist");

        return ResponseEntity.ok("Shipping unit created");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateShippingUnit(@RequestBody ShippingUnitDTO shippingUnit, @PathVariable(value = "id") int id){

        if(shippingUnit.getShippingUnitName() == null){
            return ResponseEntity.badRequest().body("Shipping unit not name");
        }
        if(shippingUnit.getEmail() == null){
            return ResponseEntity.badRequest().body("Shipping unit not email");
        }
        if(shippingUnit.getTelephone() == null){
            return ResponseEntity.badRequest().body("Shipping unit not telephone");
        }
        if(shippingUnit.getAddress() == null){
            return ResponseEntity.badRequest().body("Shipping unit not address");
        }
        if(shippingUnit.getShippingCost() == null){
            return ResponseEntity.badRequest().body("Shipping unit not shipping cost");
        }

        if(shippingUnitService.updateShippingUnit(shippingUnit, id) == null){
            return ResponseEntity.badRequest().body(ECommerceMessage.SYSTEM_ERROR);
        }

        return ResponseEntity.ok("Supplier added");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteShippingUnit(@PathVariable(value = "id") int id){
        if(shippingUnitService.deleteShippingUnit(id) == false)
            return ResponseEntity.badRequest().body(ECommerceMessage.SYSTEM_ERROR);

        return ResponseEntity.ok("Shipping unit deleted");
    }
}
