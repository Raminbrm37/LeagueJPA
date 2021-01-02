package com.maktab.league.dao.abstractdao;

import com.maktab.league.domain.parent.IEntity;

import javax.persistence.EntityManager;

public abstract class AbstractDao<E extends IEntity,T> {

    protected EntityManager entityManager;

    public AbstractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(IEntity entity){
        entityManager.persist(entity);
    }
    public void delete(IEntity entity){
        entityManager.remove(entity);
    }
    public void update(IEntity entity){
        entityManager.merge(entity);
    }
    public E loadById(T id){
        return entityManager.find(getEntityClass(),id);
    }
    public abstract Class<E> getEntityClass();
}
