package com.repository;

import java.util.List;

import com.model.entity.Film;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
public class FilmRepositoryImpl implements FilmRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertFilm(Film film) {
		entityManager.persist(film);

	}

	@Override
	public void updateFilm(Film film) {
		entityManager.merge(film);

	}

	@Override
	public void deleteFilm(Integer filmId) {
		Film filmToRemove = getFilmById(filmId);
		entityManager.remove(filmToRemove);

	}

	@Override
	public Film getFilmById(Integer filmId) {
		return entityManager.find(Film.class, filmId);
	}

	@Override
	public List<Film> getAllFilms() {
		return entityManager.createNamedQuery("Film.findAll", Film.class).getResultList();
	}

}
