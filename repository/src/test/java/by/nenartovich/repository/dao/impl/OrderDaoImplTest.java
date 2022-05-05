package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.dao.OrderDao;
import by.nenartovich.repository.entity.Order;
import by.nenartovich.repository.entity.Product;
import org.junit.Test;

import java.util.List;

import static by.nenartovich.repository.dao.MockConstant.*;
import static org.junit.Assert.*;

public class OrderDaoImplTest {

    private final OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void testGetProductList() {
        List<Product> productList = orderDao.getProductList(PRODUCT_ID);
        System.out.println(orderDao.findById(PRODUCT_ID));
        assertNotNull(productList);
        String actual = productList.get(0).getDescription();
        String expected = DESCRIPTION_PRODUCT;
        assertEquals(expected, actual);
        List<Product> productListNull = orderDao.getProductList(PRODUCT_ID2);
        assertNull(productListNull);
    }

    @Test
    public void testGetOrdersWithoutManager() {
        List<Order> orderList = orderDao.getOrdersWithoutManager();
        assertNotNull(orderList);
        Integer actual = orderList.get(0).getId();
        Integer expected = ORDER_ID;
        assertEquals(expected, actual);
        List<Product> orderListNull = orderDao.getProductList(ORDER_ID);
        assertNull(orderListNull);

    }
}