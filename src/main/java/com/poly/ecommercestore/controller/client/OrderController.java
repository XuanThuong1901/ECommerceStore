package com.poly.ecommercestore.controller.client;

import com.poly.ecommercestore.request.client.OrderRequest;
import com.poly.ecommercestore.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllOrderByCustomer(@PathVariable(value = "id") String idCustomer){
        return ResponseEntity.ok(orderService.getOrderByCustomer(idCustomer));
    }

    @GetMapping("/order={idOrder}")
    public ResponseEntity<?> getOneOrder(@PathVariable(value = "idOrder") int idOrder){
        return ResponseEntity.ok(orderService.getOneOrder(idOrder));
    }

    @PostMapping("/add/customer={idCustomer}")
    public ResponseEntity<?> addOrder(@RequestBody OrderRequest order, @PathVariable(value = "idCustomer") String idCustomer){

        if(order.getDetailOrders().size() == 0)
            return ResponseEntity.badRequest().body("Order have not detail order");
        if(order.getAddress() == null || order.getAddress().equals(""))
            return ResponseEntity.badRequest().body("Order have not address");
        if(order.getTelephone() == null || order.getTelephone().equals(""))
            return ResponseEntity.badRequest().body("Order have not telephone");
        if(order.getShippingUnit() == null)
            return ResponseEntity.badRequest().body("Order have not shipping unit");
        if(order.getPayment() == null)
            return ResponseEntity.badRequest().body("Order have not payment");

        if(orderService.addOrder(order, idCustomer) == null){
            return ResponseEntity.badRequest().body("Order created fail");
        }

        return ResponseEntity.ok("Order created");
    }

    @PostMapping("/canceled/{id}")
    public ResponseEntity<?> canceledOrder(@PathVariable(value = "id") int idOrder){
        if(orderService.statusCanceledOrder(idOrder))
            return ResponseEntity.ok("Order canceled");

        return ResponseEntity.badRequest().body("Order canceled fail");
    }
}
