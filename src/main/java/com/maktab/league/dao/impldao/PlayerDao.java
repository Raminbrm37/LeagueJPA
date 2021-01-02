package com.maktab.league.dao.impldao;

import com.maktab.league.dao.abstractdao.AbstractDao;
import com.maktab.league.domain.Player;

import javax.persistence.EntityManager;

public class PlayerDao extends AbstractDao<Player,Long> {
    public PlayerDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Player> getEntityClass() {
        return Player.class;
    }
}
