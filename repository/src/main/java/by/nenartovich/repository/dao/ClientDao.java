package by.nenartovich.repository.dao;

import by.nenartovich.repository.entity.Client;
import by.nenartovich.repository.entity.Order;

import java.util.List;

public interface ClientDao extends EntityDao<Client> {
    List<Order> getClientOrder(String name);
}
