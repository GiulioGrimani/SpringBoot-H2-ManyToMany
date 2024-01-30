package com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.entity.Actor;
import com.model.entity.Film;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FilmActorRepositoryImpl implements FilmActorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertFilmWithActors(Film film, List<Actor> actors) {
		for (Actor actor : actors) {
			entityManager.persist(actor);
			film.getActors().add(actor);
		}
		entityManager.persist(film);
	}

	@Override
	public void insertActorWithFilms(Actor actor, List<Film> films) {
		entityManager.persist(actor);
		for (Film film : films) {
			film.getActors().add(actor);
			entityManager.persist(film);
		}
	}

	@Override
	public void insertActorFilmRelation(Integer actorId, Integer filmId) {
		Actor actor = entityManager.find(Actor.class, actorId);
		Film film = entityManager.find(Film.class, filmId);
		film.getActors().add(actor);
//		entityManager.merge(film);
//
//		entityManager.createNativeQuery("INSERT INTO film_actor (actor_id, film_id) VALUES(?,?);")
//				.setParameter(1, actorId).setParameter(2, filmId).executeUpdate();

	}

	@Override
	public List<Actor> getActorsByFilm(Integer filmId) {
		return entityManager.createNamedQuery("Film.findActorsByFilm", Actor.class).setParameter("filmId", filmId)
				.getResultList();
	}

	@Override
	public List<Film> getFilmsByActor(Integer actorId) {
		return entityManager.createNamedQuery("Actor.findFilmsByActor", Film.class).setParameter("actorId", actorId)
				.getResultList();

	}

}
