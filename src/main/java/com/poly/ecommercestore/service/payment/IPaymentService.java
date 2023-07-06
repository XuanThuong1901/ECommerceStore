package com.poly.ecommercestore.service.payment;

import com.poly.ecommercestore.entity.Payments;
import com.poly.ecommercestore.request.system.PaymentRequest;

import java.util.List;

public interface IPaymentService {

    List<Payments> getAllPayment();

    Payments addPayment(PaymentRequest payment);

    Boolean updatePayment(PaymentRequest payment, int iDPayment);

    Boolean deletePayment(int iDPayment);
}
