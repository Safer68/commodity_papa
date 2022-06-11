package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.dao.DeliveryDao;
import by.nenartovich.repository.entity.Order;
import org.junit.Test;

import java.util.List;

import static by.nenartovich.repository.dao.MockConstant.*;
import static org.junit.Assert.*;

public class DeliveryDaoImplTest {
    private final DeliveryDao deliveryDao = new DeliveryDaoImpl();

   /* @Test*/
    public void testGetDeliveryOrders() {
        List<Order> orderList = deliveryDao.getDeliveryOrders(DELIVERY_NAME_BELPOST);
        assertNotNull(orderList);
        Integer actual = orderList.get(0).getId();
        Integer expected = DELIVERY_ID;
        assertEquals(expected, actual);
        List<Order> orderListNull = deliveryDao.getDeliveryOrders(DELIVERY_NAME_EUROPOST);
        assertNull(orderListNull);
    }
}