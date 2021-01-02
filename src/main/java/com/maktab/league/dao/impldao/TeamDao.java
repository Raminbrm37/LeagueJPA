package com.maktab.league.dao.impldao;

import com.maktab.league.dao.abstractdao.AbstractDao;
import com.maktab.league.domain.Team;

import javax.persistence.EntityManager;

public class TeamDao extends AbstractDao<Team,Long> {
    public TeamDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Team> getEntityClass() {
        return Team.class;
    }
}
