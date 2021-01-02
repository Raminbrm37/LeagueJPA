package com.maktab.league.dao.impldao;

import com.maktab.league.dao.abstractdao.AbstractDao;
import com.maktab.league.domain.Coach;
import com.maktab.league.domain.parent.IEntity;

import javax.persistence.EntityManager;

public class CoachDao extends AbstractDao<Coach,Long> {

    public CoachDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Coach> getEntityClass() {
        return Coach.class;
    }
}
