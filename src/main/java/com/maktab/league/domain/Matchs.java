package com.maktab.league.domain;


import com.maktab.league.domain.parent.IEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matchs implements IEntity {
    @Id
    @Column(name = "match_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "season")
    private int season;

    @ManyToOne
    @JoinColumn(name = "homeTeam_id", nullable = false,referencedColumnName = "team_id")
    private Team homeTeam;

    @Column(name = "home_gf")
    private int homeGoalFor;
    @Column(name = "home_ga")
    private int homeGoalAgainst;
    @Column(name = "home_score")
    private int homeScore;
    @ManyToOne
    @JoinColumn(name = "awayTeam_id", nullable = false,referencedColumnName = "team_id")
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "stadium_fk", referencedColumnName = "stadium_id")
    private Stadium stadium;
    @Column(name = "away_gf")
    private int awayGoalFor;
    @Column(name = "away_ga")
    private int awayGoalAgainst;
    @Column(name = "away_score")
    private int awayScore;
    @OneToMany(mappedBy = "matchs")
    private Set<MatchInformation> matchInformationSet;


    public static MatchsBuilder matchBuilder() {
        return new MatchsBuilder();
    }
}
