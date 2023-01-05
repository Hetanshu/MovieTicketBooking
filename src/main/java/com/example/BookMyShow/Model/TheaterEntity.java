package com.example.BookMyShow.Model;

import com.example.BookMyShow.enums.TheaterType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "theaters")
@Builder
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "city",nullable = false)
    private String city;

    @Enumerated(EnumType.STRING)
    TheaterType type;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheaterSeatsEntity> seats;
}
