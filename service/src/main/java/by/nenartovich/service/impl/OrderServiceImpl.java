package by.nenartovich.service.impl;

import by.nenartovich.repository.dao.impl.OrderDaoImpl;
import by.nenartovich.service.OrderService;
import by.nenartovich.service.converter.impl.OrderConverter;
import by.nenartovich.service.dto.OrderDto;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDto findById(Integer orderId) {
        return new OrderConverter().convert(new OrderDaoImpl().findById(orderId));
    }

    @Override
    public List<OrderDto> findAllOrderDto() {
        return null;
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
    }
}
