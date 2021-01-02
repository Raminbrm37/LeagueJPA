package com.maktab.league.domain;

import com.maktab.league.domain.parent.IEntity;
import com.maktab.league.domain.parent.User;
import com.maktab.league.domain.primarykeycomplex.MatchInformationId;
import com.maktab.league.domain.primarykeycomplex.TransferId;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(MatchInformationId.class)
public class MatchInformation implements IEntity {
    //

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User player;
    @Id
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Matchs matchs;
    @Column(name = "number_goal")
    private int numberOfGoal;
    @Column(name = "number_red_card")
    private int numberOfReadCard;
    @Column(name = "number_yellow_card")
    private int numberOfYellowCard;
    @Column(name = "rating")
    private int rating;
    @Column(name = "number_minutes_game")
    private int numberOfMinutesInMatch;


//    public void save(EntityManager entityManager, MatchInformation information) {
//        TransferId transferId=new TransferId();
//        transferId.setSeason(2020);
//        transferId.setUser(this.player);
//        Transfer transfer =entityManager.find(Transfer.class,transferId);
//        if (player instanceof Player && transfer.getIsActive())
//            entityManager.persist(information);
//        else {
//            System.out.println("dont save because user not e playing");
//        }
//    }

}
