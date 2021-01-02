package com.maktab.league.dao.impldao;

import com.maktab.league.dao.abstractdao.AbstractDao;
import com.maktab.league.dao.abstractdao.InheritanceDao;
import com.maktab.league.domain.Transfer;
import com.maktab.league.domain.parent.IEntity;
import com.maktab.league.domain.parent.User;
import com.maktab.league.domain.primarykeycomplex.TransferId;

import javax.persistence.EntityManager;

public class TransferDao extends AbstractDao<Transfer, Long> implements InheritanceDao<User, Long> {
    public TransferDao(EntityManager entityManager) {
        super(entityManager);
    }

    public Transfer loadById(Integer season, Long id) {
        TransferId transferId = new TransferId();
        User user1 = lod(id, entityManager);
        transferId.setSeason(season);
        transferId.setUser(user1);
        return entityManager.find(getEntityClass(), transferId);
    }

    @Override
    public void update(IEntity entity) {
        super.update(entity);
    }

    @Override
    public Class<Transfer> getEntityClass() {
        return Transfer.class;
    }



    @Override
    public Class<User> EntityClass() {
        return User.class;
    }
}
