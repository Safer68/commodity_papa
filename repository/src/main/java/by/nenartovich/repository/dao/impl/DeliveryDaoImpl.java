package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.dao.DeliveryDao;
import by.nenartovich.repository.entity.Delivery;
import by.nenartovich.repository.entity.Order;
import by.nenartovich.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DeliveryDaoImpl extends EntityDaoImpl<Delivery> implements DeliveryDao {

    public DeliveryDaoImpl() {
        super(Delivery.class);
    }

    @Override
    public List<Order> getDeliveryOrders(String name) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager
                .createQuery("SELECT E FROM Order E WHERE E.delivery.name = :name");
        query.setParameter("name", name);
        List<Order> Orders = query.getResultList();
        entityManager.close();
        return (Orders.size() != 0) ? Orders : null;
    }
}
