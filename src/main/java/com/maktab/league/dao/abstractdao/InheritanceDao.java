package com.maktab.league.dao.abstractdao;

import com.maktab.league.domain.parent.IEntity;

import javax.persistence.EntityManager;

public interface InheritanceDao<E extends IEntity, T> {

    default E lod(T id, EntityManager entityManager) {
        return entityManager.find(EntityClass(), id);
    }

    Class<E> EntityClass();

}
