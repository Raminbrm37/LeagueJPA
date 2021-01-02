package com.maktab.league.domain;

import com.maktab.league.domain.parent.User;
import lombok.*;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@DiscriminatorColumn(name = "coach")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coach extends User {
    private String lisance;

    @OneToMany(mappedBy = "user")
    private Set<Transfer> transferSet;

    public static CoachBuilder coachBuilder() {
        return new CoachBuilder();
    }
}
