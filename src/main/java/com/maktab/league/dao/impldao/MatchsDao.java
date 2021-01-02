package com.maktab.league.dao.impldao;

import com.maktab.league.dao.abstractdao.AbstractDao;
import com.maktab.league.domain.Matchs;

import javax.persistence.EntityManager;

public class MatchsDao extends AbstractDao<Matchs,Long> {
    public MatchsDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Matchs> getEntityClass() {
        return Matchs.class;
    }
}
