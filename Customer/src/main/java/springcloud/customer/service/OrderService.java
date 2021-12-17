package springcloud.customer.service;

import springcloud.customer.entities.Order;

import java.util.List;

public interface OrderService {
    int insert(Order order);
    Order selectOne(Long id);
    List<Order> selectAll();
}
