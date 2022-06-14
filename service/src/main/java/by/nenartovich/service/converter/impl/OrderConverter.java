package by.nenartovich.service.converter.impl;

import by.nenartovich.repository.dao.impl.ClientDaoImpl;
import by.nenartovich.repository.dao.impl.DeliveryDaoImpl;
import by.nenartovich.repository.dao.impl.OrderDaoImpl;
import by.nenartovich.repository.entity.Order;
import by.nenartovich.service.converter.ConverterDTO;
import by.nenartovich.service.dto.OrderDto;
import by.nenartovich.service.dto.ProductDto;

import java.text.SimpleDateFormat;

public class OrderConverter implements ConverterDTO<OrderDto, Order> {
    @Override
    public OrderDto apply(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setDataCreate(new SimpleDateFormat("dd-MM-yy HH:mm").format(order.getDateCreate()));
        orderDto.setDataChange(new SimpleDateFormat("dd-MM-yy HH:mm").format(order.getDateChange()));
        orderDto.setStatus(order.isStatus() ? "Активен" : "Выполнен");
        orderDto.setProducts(new ProductConverter().convert(new OrderDaoImpl().getProductList(orderDto.getId())));
        orderDto.setClient(new ClientConverter().convert(new ClientDaoImpl().findById(order.getClient().getId())));
        orderDto.setDelivery(new DeliveryConverter()
                .convert(new DeliveryDaoImpl().findById(order.getDelivery().getId())));
        orderDto.setPrice(orderDto.getProducts().stream().mapToDouble(ProductDto::getPrice).sum());
        return orderDto;
    }

    @Override
    public Order apply(Order order, OrderDto orderDto) {
        return order;
    }
}
