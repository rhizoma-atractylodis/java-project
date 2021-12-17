package springcloud.customer.service.impl;

import org.springframework.stereotype.Service;
import springcloud.customer.entities.Order;
import springcloud.customer.mapper.OrderMapper;
import springcloud.customer.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Order selectOne(Long id) {
        return orderMapper.selectOne(id);
    }

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }
}
