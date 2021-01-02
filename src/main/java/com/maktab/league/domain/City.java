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
public class City implements IEntity {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_name")
    private String name;
    @OneToMany(mappedBy = "city")
    private Set<Stadium> stadiumSet;
    @OneToMany(mappedBy = "city")
    private Set<Team> teamSet;


    public static CityBuilder cityBuilder() {
        return new CityBuilder();
    }
}
