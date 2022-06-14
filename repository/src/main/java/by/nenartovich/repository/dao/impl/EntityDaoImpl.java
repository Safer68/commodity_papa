package by.nenartovich.repository.dao.impl;


import by.nenartovich.repository.dao.EntityDao;
import by.nenartovich.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

abstract class EntityDaoImpl<T> implements EntityDao<T> {
    private final Class<T> aClass;

    public EntityDaoImpl(Class<T> aClass) {
        this.aClass = aClass;
    }


    @Override
    public T findById(final Integer id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        T entity;
        entity = entityManager.find(aClass, id);
        entityManager.close();
        return entity;
    }

    @Override
    public List<T> findAll() {
        List<T> allQuery = null;
        EntityManager entityManager = HibernateUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> rootEntry = criteriaQuery.from(aClass);
        criteriaQuery.select(rootEntry);
        allQuery = entityManager.createQuery(criteriaQuery).getResultList();
        entityManager.close();
        return allQuery;
    }

    @Override
    public void save(T t) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void save(List<T> list) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        list.forEach(entityManager::persist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(T t) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Integer id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        T entity = entityManager.find(aClass, id);
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
