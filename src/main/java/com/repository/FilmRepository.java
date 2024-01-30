package com.repository;

import java.util.List;

import com.model.entity.Film;

public interface FilmRepository {
	void insertFilm(Film film);

	void updateFilm(Film film);

	void deleteFilm(Integer filmId);

	Film getFilmById(Integer filmId);

	List<Film> getAllFilms();
}
