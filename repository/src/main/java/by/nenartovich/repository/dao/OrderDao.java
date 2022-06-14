package by.nenartovich.repository.dao;

import by.nenartovich.repository.entity.Order;
import by.nenartovich.repository.entity.Product;

import java.util.List;

public interface OrderDao extends EntityDao<Order> {

    List<Product> getProductList(Integer orderId);

    List<Order> getOrdersWithoutManager();

}
