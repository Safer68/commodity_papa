package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.dao.OrderDao;
import by.nenartovich.repository.entity.Order;
import by.nenartovich.repository.entity.Product;
import by.nenartovich.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class OrderDaoImpl extends EntityDaoImpl<Order> implements OrderDao {
    public OrderDaoImpl() {
        super(Order.class);
    }

    @Override
    public List<Product> getProductList(Integer orderId) {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT E.products from Order E WHERE E.id= :id");
        query.setParameter("id", orderId);
        List<Product> products = query.getResultList();
        entityManager.close();
        return (products.size() != 0) ? products : null;
    }

    @Override
    public List<Order> getOrdersWithoutManager() {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT E from Order E WHERE E.manager= null ");
        List<Order> products = query.getResultList();
        entityManager.close();
        return products;
    }
}
