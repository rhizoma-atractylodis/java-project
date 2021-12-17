package springcloud.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.commons.entities.CommonResult;
import springcloud.customer.entities.Order;
import springcloud.customer.entities.Payment;
import springcloud.customer.service.OrderService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private RestTemplate restTemplate;
    private static final String PAYMENT_INTERFACE = "http://localhost:8080";

    @PostMapping("/springcloud/customer/insert")
    public CommonResult create(Order order, Payment payment) {
        int result = orderService.insert(order);
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_INTERFACE + "/payment/create", payment, CommonResult.class);
        if (result > 0) {
            log.info("successfully insert...");
        } else {
            log.info("bad pojo exception...");
        }
        return commonResult;
    }
}
