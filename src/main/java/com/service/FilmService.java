package com.service;

import java.util.List;

public interface FilmService {

    void insertFilm(Film film);

    void updateFilm(Film film);

    void deleteFilm(Integer filmId);

    Film getFilmById(Integer filmId);

    List<Film> getAllFilms();

}
