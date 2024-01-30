package com.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// List<Film> getFilmsByActor(Integer actorId);

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "films")
@Entity
@NamedQueries({
        @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
        @NamedQuery(name = "Actor.findById", query = "SELECT a FROM Actor a WHERE a.actorId = :actorId"),
        @NamedQuery(name = "Actor.findFilmsByActor", query = "SELECT a.films FROM Actor a WHERE actorId = :actorId")

})
public class Actor {

    @Column(name = "actor_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // bi-directional many-to-many association to Film
    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
