package com.poly.ecommercestore.controller.system;

import com.poly.ecommercestore.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/order")
public class OrderSystemController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<?> getAllOrderByCustomer(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/order={idOrder}")
    public ResponseEntity<?> getOneOrder(@PathVariable(value = "idOrder") int idOrder){
        return ResponseEntity.ok(orderService.getOneOrder(idOrder));
    }

    @PostMapping("/confirmed/{id}")
    public ResponseEntity<?> confirmedOrder(@PathVariable(value = "id") int idOrder){
        if(orderService.statusConfirmedOrder(idOrder))
            return ResponseEntity.ok("Order confirmed");

        return ResponseEntity.badRequest().body("Order confirmed fail");
    }

    @PostMapping("/delivery/{id}")
    public ResponseEntity<?> deliveryOrder(@PathVariable(value = "id") int idOrder){
        if(orderService.statusDeliveryOrder(idOrder))
            return ResponseEntity.ok("Order delivery");

        return ResponseEntity.badRequest().body("Order delivery fail");
    }

    @PostMapping("/delivered/{id}")
    public ResponseEntity<?> deliveredOrder(@PathVariable(value = "id") int idOrder){
        if(orderService.statusDeliveredOrder(idOrder))
            return ResponseEntity.ok("Order delivered");

        return ResponseEntity.badRequest().body("Order delivered fail");
    }

    @PostMapping("/canceled/{id}")
    public ResponseEntity<?> canceledOrder(@PathVariable(value = "id") int idOrder){
        if(orderService.statusCanceledOrder(idOrder))
            return ResponseEntity.ok("Order canceled");

        return ResponseEntity.badRequest().body("Order canceled fail");
    }
}
