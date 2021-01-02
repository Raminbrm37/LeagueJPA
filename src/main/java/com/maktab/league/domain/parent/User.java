package com.maktab.league.domain.parent;


import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_name")
public abstract class User implements IEntity  {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_code", nullable = false, unique = true, length = 10)
    private String nationalCode;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthDay;
//    @Formula(value = "date_part('year', age(birthday))")
//    private int age;
}
