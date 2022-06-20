package by.nenartovich.service;

import by.nenartovich.service.dto.ClientDto;
import by.nenartovich.service.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto findById(Integer orderId);

    List<OrderDto> findAllOrderDto();

    void updateOrder(OrderDto orderDto);
}
