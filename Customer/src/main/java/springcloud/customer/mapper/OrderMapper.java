package springcloud.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import springcloud.customer.entities.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    int insert(Order order);
    Order selectOne(Long id);
    List<Order> selectAll();
}
