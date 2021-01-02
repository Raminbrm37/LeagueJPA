package com.maktab.league.dao.impldao;

import com.maktab.league.dao.abstractdao.AbstractDao;
import com.maktab.league.dao.abstractdao.ComplexKeyDao;
import com.maktab.league.dao.abstractdao.InheritanceDao;
import com.maktab.league.domain.MatchInformation;
import com.maktab.league.domain.Matchs;
import com.maktab.league.domain.Player;
import com.maktab.league.domain.Transfer;
import com.maktab.league.domain.parent.IEntity;
import com.maktab.league.domain.parent.User;
import com.maktab.league.domain.primarykeycomplex.MatchInformationId;
import com.maktab.league.domain.primarykeycomplex.TransferId;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class MatchInfoDao extends AbstractDao<MatchInformation,Long> implements ComplexKeyDao<Matchs,User,Long>, Serializable {
    public MatchInfoDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<MatchInformation> getEntityClass() {
        return MatchInformation.class;
    }


    public MatchInformation loadById(Long playerId,Long matchsId) {
        MatchInformationId matchInformationId=new MatchInformationId();
        User player=lodV(playerId,entityManager);
        Matchs matchs=lodE(matchsId,entityManager);
        matchInformationId.setMatchs(matchs);
        matchInformationId.setPlayer(player);
        return entityManager.find(getEntityClass(),matchInformationId);
    }


    public void save(MatchInformation entity) {
        TransferId transferId=new TransferId();
        transferId.setSeason(2020);
        transferId.setUser(entity.getPlayer());
        Transfer transfer =entityManager.find(Transfer.class,transferId);
        if (entity.getPlayer() instanceof Player && transfer.getIsActive())
            super.save(entity);
        else {
            System.out.println("dont save because user not e playing");
        }

    }

    @Override
    public Class<User> EntityClassV() {
        return User.class;
    }

    @Override
    public Class<Matchs> EntityClassE() {
        return Matchs.class;
    }
}
