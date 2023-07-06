package com.poly.ecommercestore.request.system;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PaymentRequest {

    private String paymentName;
    private String contents;

    public PaymentRequest() {
    }

    public PaymentRequest(String paymentName, String contents) {
        this.paymentName = paymentName;
        this.contents = (contents != null) ? contents : "N/A";
    }
}
