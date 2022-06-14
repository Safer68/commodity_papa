package by.nenartovich.repository.dao;

import by.nenartovich.repository.entity.Delivery;
import by.nenartovich.repository.entity.Order;

import java.util.List;

public interface DeliveryDao extends EntityDao<Delivery> {
    List<Order> getDeliveryOrders(String name);

}
