package com.maktab.league.domain.primarykeycomplex;

import com.maktab.league.domain.Player;
import com.maktab.league.domain.parent.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TransferId implements Serializable {

   @Column(name = "season")
   private int season;

   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false)
   private User user;

}
