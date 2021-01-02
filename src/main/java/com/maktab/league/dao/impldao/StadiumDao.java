package com.maktab.league.dao.impldao;

import com.maktab.league.dao.abstractdao.AbstractDao;
import com.maktab.league.domain.Stadium;

import javax.persistence.EntityManager;

public class StadiumDao extends AbstractDao<Stadium,Long> {
    public StadiumDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Stadium> getEntityClass() {
        return Stadium.class;
    }
}
