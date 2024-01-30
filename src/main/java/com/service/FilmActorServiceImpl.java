package com.service;

import java.util.List;

import com.model.entity.Film;

public class FilmActorServiceImpl implements FilmActorService {

    @Override
    public void insertFilmWithActors(Film film, List<Actor> actors) {

        try {

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error in insertFilmWithActors()");
        }

    }

    @Override
    public void insertActorWithFilms(Actor actor, List<Film> films) {

        try {

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error in insertActorWithFilms()");
        }
    }

    @Override
    public void insertActorFilmRelation(Integer actorId, Integer filmId) {

        try {

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error in insertActorFilmRelation()");
        }
    }

    @Override
    public List<Actor> getActorsByFilm(Integer filmId) {

        try {

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error in getActorsByFilm()");
        }
    }

    @Override
    public List<Film> getFilmsByActor(Integer actorId) {

        try {

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error in getFilmsByActor()");
        }
    }

}
