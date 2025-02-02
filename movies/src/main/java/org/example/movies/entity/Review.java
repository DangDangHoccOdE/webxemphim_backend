package org.example.movies.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "comment", nullable = false, columnDefinition = "TEXT")
    @Lob
    private String comment;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "rating", nullable = false, columnDefinition = "DECIMAL(2,1) DEFAULT 0.0 CHECK (rating >= 0.0 AND rating <= 5.0")
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade =  {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "movie_id")
    private Movie movie;


}
