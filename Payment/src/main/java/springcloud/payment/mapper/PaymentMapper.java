package springcloud.payment.mapper;

import org.apache.ibatis.annotations.Mapper;
import springcloud.payment.entities.Payment;

import java.util.List;

@Mapper
public interface PaymentMapper {
    int insert(Payment payment);
    Payment selectOnePayment(Long id);
    List<Payment> selectAll();
}
