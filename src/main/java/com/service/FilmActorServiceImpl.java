package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.entity.Actor;
import com.model.entity.Film;
import com.repository.FilmActorRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;

public class FilmActorServiceImpl implements FilmActorService {

    @Autowired
    private FilmActorRepository far;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void insertFilmWithActors(Film film, List<Actor> actors) {
        try {
            far.insertFilmWithActors(film, actors);
        } catch (IllegalArgumentException | TransactionRequiredException | EntityExistsException e) {
            e.printStackTrace();
            log.error("Error in insertFilmWithActors()");
        }
    }

    @Override
    public void insertActorWithFilms(Actor actor, List<Film> films) {
        try {
            far.insertActorWithFilms(actor, films);
        } catch (IllegalArgumentException | TransactionRequiredException | EntityExistsException e) {
            e.printStackTrace();
            log.error("Error in insertActorWithFilms()");
        }
    }

    @Override
    public void insertActorFilmRelation(Integer actorId, Integer filmId) {
        try {
            far.insertActorFilmRelation(actorId, filmId);
        } catch (IllegalArgumentException | TransactionRequiredException | EntityExistsException e) {
            e.printStackTrace();
            log.error("Error in insertActorFilmRelation()");
        }
    }

    @Override
    public List<Actor> getActorsByFilm(Integer filmId) {
        List<Actor> actors = null;
        try {
            actors = far.getActorsByFilm(filmId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            log.error("Error in getActorsByFilm()");
        }
        return actors;
    }

    @Override
    public List<Film> getFilmsByActor(Integer actorId) {
        List<Film> films = null;
        try {
            films = far.getFilmsByActor(actorId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            log.error("Error in getFilmsByActor()");
        }
        return films;
    }

}
