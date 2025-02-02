package org.example.movies.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "title", nullable = false, unique = true, length = 255)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    @Lob
    private String description;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "director", nullable = false, length = 100)
    private String director;

    @Column(name = "actors", nullable = false, columnDefinition = "TEXT")
    private String actors;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "trailer_url", length = 500)
    private String trailerUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @OneToMany(mappedBy = "movie",cascade =  {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private List<Review> reviews;
}
