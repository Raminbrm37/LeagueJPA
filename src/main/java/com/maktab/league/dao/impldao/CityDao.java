package com.maktab.league.dao.impldao;

import com.maktab.league.dao.abstractdao.AbstractDao;
import com.maktab.league.domain.City;
import com.maktab.league.domain.parent.IEntity;

import javax.persistence.EntityManager;

public class CityDao extends AbstractDao<City,Long> {
    public CityDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}
