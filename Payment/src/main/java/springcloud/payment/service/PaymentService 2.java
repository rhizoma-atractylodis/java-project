package springcloud.payment.service;

import springcloud.payment.entities.Payment;

import java.util.List;

public interface PaymentService {
    int insert(Payment payment);
    Payment selectOnePayment(Long id);
    List<Payment> selectAll();
}
