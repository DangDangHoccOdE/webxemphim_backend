package org.example.showtimes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "showtime")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showtime_id")
    private int showTimeId;

    @Column(name = "start_time", nullable = false, columnDefinition = "TIMESTAMP NOT NULL")
    private Timestamp startTime;

    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(10,2) CHECK (price >= 0)")
    private Double price;

    private Long movie_id;

    private Long room_id;
}
