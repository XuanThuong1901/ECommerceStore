package com.poly.ecommercestore.controller.system;

import com.poly.ecommercestore.DTO.system.PaymentDTO;
import com.poly.ecommercestore.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public ResponseEntity<?> getAllPayment(){
        return ResponseEntity.ok(paymentService.getAllPayment());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPayment(@RequestBody PaymentDTO payment){

        if(payment.getPaymentName() == null || payment.getPaymentName().equals("")){
            return ResponseEntity.badRequest().body("Payment not name");
        }

        if(paymentService.addPayment(payment) != null)
            return ResponseEntity.ok("Payment created");

        return ResponseEntity.badRequest().body("Payment created fail");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updatePayment(@RequestBody PaymentDTO payment, @PathVariable(value = "id") int idPayment){

        if(payment.getPaymentName() == null || payment.getPaymentName().equals("")){
            return ResponseEntity.badRequest().body("Payment not name");
        }

        if(paymentService.updatePayment(payment, idPayment) == true)
            return ResponseEntity.ok("Payment updated");

        return ResponseEntity.badRequest().body("Payment updated fail");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable(value = "id") int idPayment){

        if(paymentService.deletePayment(idPayment) == true)
            return ResponseEntity.ok("Payment deleted");

        return ResponseEntity.badRequest().body("Payment deleted fail");
    }
}
