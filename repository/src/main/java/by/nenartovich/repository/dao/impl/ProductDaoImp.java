package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.Section;
import by.nenartovich.repository.dao.ProductDao;
import by.nenartovich.repository.entity.Product;
import by.nenartovich.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductDaoImp extends EntityDaoImpl<Product> implements ProductDao {
    public ProductDaoImp() {
        super(Product.class);
    }

    @Override
    public List<Product> getSectionProducts(Section section) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT E from Product E WHERE E.section= :section");
        query.setParameter("section", section);
        List<Product> products = query.getResultList();
        entityManager.close();
        return (products.size() != 0) ? products : null;
    }
}
