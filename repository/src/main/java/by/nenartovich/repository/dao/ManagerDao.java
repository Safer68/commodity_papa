package by.nenartovich.repository.dao;

import by.nenartovich.repository.entity.Client;
import by.nenartovich.repository.entity.Manager;
import by.nenartovich.repository.entity.Order;

import java.util.List;

public interface ManagerDao extends EntityDao<Manager>{
    List<Order> getManagerOrders(Integer managerId);

    List<Client> getManagerClients(String name);

}
