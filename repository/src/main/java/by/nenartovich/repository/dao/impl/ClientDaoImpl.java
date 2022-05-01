package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.dao.ClientDao;
import by.nenartovich.repository.entity.Client;
import by.nenartovich.repository.entity.Order;
import by.nenartovich.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClientDaoImpl extends EntityDaoImpl<Client> implements ClientDao {
    public ClientDaoImpl() {
        super(Client.class);
    }

    @Override
    public List<Order> getClientOrder(String name) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager
                .createQuery("SELECT E.orders FROM Client E WHERE E.name = :name");
        query.setParameter("name", name);
        List<Order> Orders = query.getResultList();
        entityManager.close();
        return Orders;
    }
}
