package springcloud.payment.service.impl;

import org.springframework.stereotype.Service;
import springcloud.payment.entities.Payment;
import springcloud.payment.mapper.PaymentMapper;
import springcloud.payment.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int insert(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment selectOnePayment(Long id) {
        return paymentMapper.selectOnePayment(id);
    }

    @Override
    public List<Payment> selectAll() {
        return paymentMapper.selectAll();
    }
}
