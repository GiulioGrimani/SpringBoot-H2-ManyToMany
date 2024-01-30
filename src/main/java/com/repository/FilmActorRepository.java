package com.repository;

import java.util.List;

import com.model.entity.Actor;
import com.model.entity.Film;

public interface FilmActorRepository {
	void insertFilmWithActors(Film film, List<Actor> actors);

	void insertActorWithFilms(Actor actor, List<Film> films);

	void insertActorFilmRelation(Integer actorId, Integer filmId);

	List<Actor> getActorsByFilm(Integer filmId);

	List<Film> getFilmsByActor(Integer actorId);
}
