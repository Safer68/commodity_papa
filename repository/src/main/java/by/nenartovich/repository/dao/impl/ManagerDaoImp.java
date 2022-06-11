package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.dao.ManagerDao;
import by.nenartovich.repository.entity.Client;
import by.nenartovich.repository.entity.Manager;
import by.nenartovich.repository.entity.Order;
import by.nenartovich.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ManagerDaoImp extends EntityDaoImpl<Manager> implements ManagerDao {
    public ManagerDaoImp() {
        super(Manager.class);
    }

    @Override
    public List<Order> getManagerOrders(Integer managerId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager
                .createQuery("SELECT E.orders FROM Manager E WHERE E.id = :managerId");
        query.setParameter("managerId", managerId);
        List<Order> Orders = query.getResultList();
        entityManager.close();
        return (Orders.size() != 0) ? Orders : null;
    }

    @Override
    public List<Client> getManagerClients(String name) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager
                .createQuery("SELECT E.client FROM Order E WHERE E.manager.name = :name");
        query.setParameter("name", name);
        List<Client> Clients = query.getResultList();
        entityManager.close();
        return (Clients.size() != 0) ? Clients : null;
    }
}
