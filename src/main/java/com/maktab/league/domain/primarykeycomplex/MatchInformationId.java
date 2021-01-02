package com.maktab.league.domain.primarykeycomplex;

import com.maktab.league.domain.Matchs;
import com.maktab.league.domain.parent.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class MatchInformationId implements Serializable {


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User player;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Matchs matchs;



}
