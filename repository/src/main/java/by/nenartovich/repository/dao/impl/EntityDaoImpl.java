package by.nenartovich.repository.dao.impl;


import by.nenartovich.repository.dao.EntityDao;
import by.nenartovich.repository.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
        EntityManager entityManager = HibernateUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(aClass);
        Root<T> rootEntry = criteriaQuery.from(aClass);
        CriteriaQuery<T> all = criteriaQuery.select(rootEntry);
        TypedQuery<T> allQuery = entityManager.createQuery(all);
        entityManager.close();
        return allQuery.getResultList();
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

    }

    @Override
    public void delete(T t) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.merge(t);
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
    }
}
