package com.poly.ecommercestore.controller.client;

import com.poly.ecommercestore.DTO.client.CartDTO;
import com.poly.ecommercestore.service.cart.CartService;
import com.poly.ecommercestore.service.shared.ECommerceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{idCustomer}")
    public ResponseEntity<?> getCart(@PathVariable(value = "idCustomer") String idCustomer){
        return ResponseEntity.ok(cartService.getCartByCustomer(idCustomer));
    }

    @PostMapping("/add/customer={idCustomer}/product={idProduct}")
    public ResponseEntity<?> addCart(@RequestBody CartDTO cart, @PathVariable(value = "idCustomer") String idCustomer, @PathVariable(value = "idProduct") int idProduct){
        if(cart.getQuantity() == null || cart.getQuantity() == 0)
            return ResponseEntity.badRequest().body("have not quantity");

        if(cartService.addCart(idCustomer, idProduct, cart) == null)
            return ResponseEntity.badRequest().body("Created cart fail");

        return ResponseEntity.ok(ECommerceMessage.ADD_TO_CART);
    }

    @PostMapping("/update/customer={idCustomer}/product={idProduct}")
    public ResponseEntity<?> updateCart(@RequestBody CartDTO cart, @PathVariable(value = "idCustomer") String idCustomer, @PathVariable(value = "idProduct") int idProduct){
        if(cart.getQuantity() == null || cart.getQuantity() == 0)
            return ResponseEntity.badRequest().body("have not quantity");

        if(cartService.updateCart(idCustomer, idProduct, cart) == false)
            return ResponseEntity.badRequest().body("Updated cart fail");

        return ResponseEntity.ok("Updated cart");
    }

    @DeleteMapping("/delete/customer={idCustomer}/product={idProduct}")
    public ResponseEntity<?> deleteCart(@PathVariable(value = "idCustomer") String idCustomer, @PathVariable(value = "idProduct") int idProduct){

        if(cartService.deleteCart(idCustomer, idProduct) == false)
            return ResponseEntity.badRequest().body("Deleted cart fail");

        return ResponseEntity.ok("Deleted cart");
    }
}
