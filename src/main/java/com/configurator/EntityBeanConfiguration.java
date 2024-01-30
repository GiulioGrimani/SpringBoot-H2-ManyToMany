package com.configurator;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.model.entity.Actor;
import com.model.entity.Film;

@Configuration
public class EntityBeanConfiguration {

	/*
	 * BEANS SU ACTOR
	 * 
	 */

	@Bean("actorToInsert")
	Actor getActorToInsert(String firstName, String lastName) {
		return new Actor(firstName, lastName);
	}

	@Bean("actorVO")
	Actor getActorVO(Integer actorId, String firstName, String lastName, List<Film> films) {
		return new Actor(actorId, firstName, lastName, films);
	}

	@Bean("actorToUpdate")
	Actor getActorToUpdate(Integer id, String firstName, String lastName) {
		Actor actor = new Actor(firstName, lastName);
		actor.setActorId(id);
		return actor;
	}

	/*
	 * BEANS SU FILM
	 */

	@Bean("filmToInsert")
	Film getFilmToInsert(String title) {
		return new Film(title);
	}

	@Bean("filmVO")
	Film getFilmToUpdate(Integer filmId, String title, List<Actor> cast) {
		return new Film(filmId, title, cast);
	}

	@Bean("filmToUpdate")
	Film getFilmToUpdate(Integer id, String title) {
		Film film = new Film(title);
		film.setFilmId(id);
		return film;
	}

	/*
	 * BEANS COMMON
	 */
	@Bean("filmToInsertWithCast")
	Film getFilmToInsertWithCast(String title, List<Actor> cast) {
		Film film = new Film(title);
		film.setActors(cast);
		return film;
	}

	@Bean("actorToInsertWithCast")
	Actor getActorToInsertWithCast(String firstName, String lastName, List<Film> films) {
		Actor actor = new Actor(firstName, lastName);
		actor.setFilms(films);
		return actor;
	}
}
