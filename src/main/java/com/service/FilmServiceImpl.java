package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.entity.Film;
import com.repository.FilmRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;

public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmRepository fr;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void insertFilm(Film film) {
		try {
			fr.insertFilm(film);
		} catch (IllegalArgumentException | TransactionRequiredException | EntityExistsException e) {
			e.printStackTrace();
			log.error("Error in insertFilm()");
		}
	}

	@Override
	public void updateFilm(Film film) {
		try {
			fr.updateFilm(film);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in updateFilm()");
		}
	}

	@Override
	public void deleteFilm(Integer filmId) {
		try {
			fr.deleteFilm(filmId);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in deleteFilm()");
		}
	}

	@Override
	public Film getFilmById(Integer filmId) {
		Film film = null;
		try {
			film = fr.getFilmById(filmId);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.err.println("Error in getFilmById()");
		}

		return film;
	}

	@Override
	public List<Film> getAllFilms() {
		List<Film> films = null;
		try {
			films = fr.getAllFilms();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.err.println("Error in getAllFilms()");
		}

		return films;
	}

}
