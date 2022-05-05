package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.dao.ClientDao;
import by.nenartovich.repository.dao.MockConstant;
import by.nenartovich.repository.entity.Client;
import by.nenartovich.repository.entity.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static by.nenartovich.repository.dao.MockConstant.*;
import static org.junit.Assert.*;

public class ClientDaoImplTest {

    private final ClientDao clientDao = new ClientDaoImpl();

    @Test
    public void testFindById() {
        String actual = clientDao.findById(CLIENT_BY_ID).toString();
        assertEquals(EXPECTED_CLIENT_FIND_BY_ID, actual);
    }

    @Test
    public void testFindAll() {
        List<Client> expectedList = new ArrayList<>();
        expectedList.add(clientDao.findById(CLIENT_BY_ID));
        List<Client> actualList = clientDao.findAll();
        assertNotNull(actualList);
        assertArrayEquals(expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void testSaveAndDelete() {
        Client client = Client.builder().name(NAME_CLIENT_PETYA).build();
        clientDao.save(client);
        assertNotNull(clientDao.findById(client.getId()));
        clientDao.delete(client.getId());
        assertNull(clientDao.findById(client.getId()));
    }

    @Test
    public void testUpdate() {
        Client client = Client.builder().name(NAME_CLIENT_PETYA).build();
        clientDao.save(client);
        assertNotNull(clientDao.findById(client.getId()));
        client.setName(NAME_CLIENT_VASYA);
        clientDao.update(client);
        Client actual = clientDao.findById(client.getId());
        assertEquals(client.getName(), actual.getName());
        clientDao.delete(client.getId());
        assertNull(clientDao.findById(client.getId()));
    }

    @Test
    public void testGetClientOrder() {
        List<Order> orderList = clientDao.getClientOrder(NAME_CLIENT_VASYA);
        assertNotNull(orderList);
        Integer actual = orderList.get(0).getId();
        Integer expected = CLIENT_BY_ID;
        assertEquals(expected, actual);
        List<Order> orderListNull = clientDao.getClientOrder(MockConstant.NAME_CLIENT_PETYA);
        assertNull(orderListNull);
    }
}