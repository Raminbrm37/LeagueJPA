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
public class Stadium implements IEntity {

    @Id
    @Column(name = "stadium_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stadium_name")
    private String name;
    @Column(name = "capacity")
    private Long capacity;
    @ManyToOne
    @JoinColumn(name = "city_fk", referencedColumnName = "city_id")
    private City city;
    @OneToMany(mappedBy = "stadium")
    private Set<Matchs> matchsSet;

    public static StadiumBuilder stadiumBuilder() {
        return new StadiumBuilder();
    }
}
