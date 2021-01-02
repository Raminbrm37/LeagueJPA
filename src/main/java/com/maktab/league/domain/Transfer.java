package com.maktab.league.domain;

//import com.maktab.league.domain.primarykeycomplex.TransferId;

import com.maktab.league.domain.enumclasses.UserEnum;
import com.maktab.league.domain.parent.IEntity;
import com.maktab.league.domain.parent.User;
import com.maktab.league.domain.primarykeycomplex.TransferId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"season", "user_id"})
})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(TransferId.class)
public class Transfer implements Serializable, IEntity {

    private Date startingDate;
    @Column(name = "transfer_duration")
    private int duration;
    @Column(name = "salary")
    private double salary;

    @Id
    @Column(name = "season")
    private int season;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = true)
    private Team team;

    @Enumerated(EnumType.STRING)
    private UserEnum userEnum;
    @Column
    private Boolean isActive;

    @PrePersist
    public void prePersist() {
        if (userEnum == null) //We set default value in case if the value is not set yet.
            userEnum = userDetection();
        if (isActive == null)
            isActive = contractDetection();

    }

    private Boolean contractDetection() {
        return this.team != null;
    }

    public UserEnum userDetection() {

        if (user instanceof Player) {
            return UserEnum.PLAYER;
        } else {
            return UserEnum.COACH;
        }
    }

}
