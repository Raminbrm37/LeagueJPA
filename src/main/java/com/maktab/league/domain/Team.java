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
public class Team implements IEntity {
    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "team_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_fk", referencedColumnName = "city_id")
    private City city;
    @OneToMany(mappedBy = "homeTeam")
    private Set<Matchs> homeMatchSet;
    @OneToMany(mappedBy = "awayTeam")
    private Set<Matchs> awaMatchSet;
    @OneToMany(mappedBy = "team")
    private Set<Transfer>transferSet;

    public static TeamBuilder teamBuilder() {
        return new TeamBuilder();
    }
}
