package com.service;

import java.util.List;

import com.model.entity.Film;

public interface FilmService {

    void insertFilm(Film film);

    void updateFilm(Film film);

    void deleteFilm(Integer filmId);

    Film getFilmById(Integer filmId);

    List<Film> getAllFilms();

}
