package org.example.cinemas.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private int cinema_id;

    @Column(name = "cinema_name")
    private String cinemaName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "created_at")
    private Date createdAt;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    private List<Room> rooms;
}
