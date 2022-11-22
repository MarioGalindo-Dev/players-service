package com.soccer.players.entities;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;
    private Integer teamID;
    private String number;
    private String name;
    private Date  dateOfBirth;
    private String age;
    private int scoredGoalsInTournament;
    private Date joinDate;
    private Date leftDate;
}
