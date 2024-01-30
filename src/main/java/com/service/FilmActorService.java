package com.service;

import java.util.List;

import com.model.entity.Film;

public interface FilmActorService {

    void insertFilmWithActors(Film film, List<Actor> actors);

    void insertActorWithFilms(Actor actor, List<Film> films);

    void insertActorFilmRelation(Integer actorId, Integer filmId);

    List<Actor> getActorsByFilm(Integer filmId);

    List<Film> getFilmsByActor(Integer actorId);
}
