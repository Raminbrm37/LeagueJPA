package com.maktab.league.domain;

import com.maktab.league.domain.enumclasses.Position;
import com.maktab.league.domain.parent.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@DiscriminatorColumn(name = "player")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player extends User {
    @Enumerated(EnumType.STRING)
    private Position position;

    @OneToMany(mappedBy = "user")
    private Set<Transfer>transferSet;
    @OneToMany(mappedBy = "player")
    private Set<MatchInformation>matchInformationSet;

    public static PlayerBuilder playerBuilder() {
        return new PlayerBuilder();
    }

}
