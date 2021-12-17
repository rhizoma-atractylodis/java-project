package springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.commons.entities.CommonResult;
import springcloud.payment.entities.Payment;
import springcloud.payment.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/springcloud/payment/create")
    public CommonResult<Integer> insert(Payment payment) {
        int result = paymentService.insert(payment);
        if (result > 0) {
            log.info("successfully insert...");
            return new CommonResult<>(200, "successfully insert", result);
        } else {
            log.info("bad pojo exception...");
            return new CommonResult<>(405, "bad pojo exception", -1);
        }
    }

    @GetMapping("/springcloud/payment/getById")
    public CommonResult<Payment> selectOne(Long id) {
        Payment payment = paymentService.selectOnePayment(id);
        if (payment != null) {
            log.info("successfully select payment - " + payment);
            return new CommonResult<>(200, "successfully select", payment);
        } else {
            log.info("select error...");
            return new CommonResult<>(405, "select error", null);
        }
    }

    @GetMapping("/springcloud/payment/getList")
    public CommonResult<List<Payment>> selectAll() {
        List<Payment> payments = paymentService.selectAll();
        if (payments != null) {
            log.info("successfully select payments - " + payments);
            return new CommonResult<>(200, "successfully select", payments);
        } else {
            log.info("select error...");
            return new CommonResult<>(405, "select error", null);
        }
    }
}
