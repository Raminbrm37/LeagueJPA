package com.maktab.league.dao.abstractdao;

import javax.persistence.EntityManager;
import java.io.Serializable;

public interface ComplexKeyDao<E,V,T> extends Serializable {

    default E lodE(T id, EntityManager entityManager) {
        return entityManager.find(EntityClassE(), id);
    }


    default V lodV(T id, EntityManager entityManager) {
        return entityManager.find(EntityClassV(), id);
    }

    Class<V> EntityClassV();
    Class<E> EntityClassE();
}
