package com.example.BookMyShow.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "mobile",nullable = false)
    private String mobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)   //bidirectional mapping (relationship)
    private List<TicketEntity> ticketEntities;
}
