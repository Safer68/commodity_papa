package by.nenartovich.repository;

import by.nenartovich.repository.dao.ClientDao;
import by.nenartovich.repository.dao.impl.ClientDaoImpl;
import by.nenartovich.repository.entity.Client;
import by.nenartovich.repository.entity.Order;
import by.nenartovich.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Tdf {
    public static void main(String[] args) {
        Client client = Client.builder().name("Петя").build();
        Order order = Order.builder().build();
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        entityManager.close();
        ClientDao clientDao = new ClientDaoImpl();
        List<Order> orderList = clientDao.getClientOrder("Петя");
        orderList.forEach(System.out::println);

    }
}
