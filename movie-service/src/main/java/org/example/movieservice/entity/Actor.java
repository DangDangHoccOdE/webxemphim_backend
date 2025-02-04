package org.example.movieservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actor")
@Builder
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;
    private String actorName;

    @ManyToOne
    @JsonIgnore
    private Movie movie;

    @OneToOne(mappedBy = "actor")
    @JoinColumn(name = "actor_image_id")
    private ActorImage actorImage;
}
