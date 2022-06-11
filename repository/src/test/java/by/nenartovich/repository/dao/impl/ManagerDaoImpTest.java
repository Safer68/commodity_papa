package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.dao.ManagerDao;
import by.nenartovich.repository.entity.Client;
import by.nenartovich.repository.entity.Order;
import org.junit.Test;

import java.util.List;

import static by.nenartovich.repository.dao.MockConstant.*;
import static org.junit.Assert.*;


public class ManagerDaoImpTest {

    private final ManagerDao managerDaoImp = new ManagerDaoImp();

    /*@Test
    public void testGetManagerOrders() {
        List<Order> orderList = managerDaoImp.getManagerOrders(MANAGER_NAME_ONE);
        assertNotNull(orderList);
        Integer actual = orderList.get(0).getId();
        Integer expected = MANAGER_ID;
        assertEquals(expected, actual);
        List<Order> orderListNull = managerDaoImp.getManagerOrders(MANAGER_NAME_TWO);
        assertNull(orderListNull);
    }*/

   /* @Test*/
    public void testGetManagerClients() {
        List<Client> orderList = managerDaoImp.getManagerClients(MANAGER_NAME_ONE);
        assertNotNull(orderList);
        String actual = orderList.get(0).getName();
        assertEquals(NAME_CLIENT_VASYA, actual);
        List<Client> orderListNull = managerDaoImp.getManagerClients(MANAGER_NAME_TWO);
        assertNull(orderListNull);
    }
}