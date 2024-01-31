package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.model.entity.Actor;
import com.model.entity.Film;
import com.service.ActorService;
import com.service.FilmActorService;
import com.service.FilmService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class SpringBootH2ManyToManyApplication implements CommandLineRunner {

	@Autowired
	private FilmService filmService;

	@Autowired
	private ActorService actorService;

	@Autowired
	private FilmActorService filmActorService;

	@Resource(name = "actorBean")
	private Actor actor;
	@Resource(name = "actorBean")
	private Actor actor2;
	@Resource(name = "actorBean")
	private Actor actor3;
	@Resource(name = "actorBean")
	private Actor actor4;
	@Resource(name = "actorBean")
	private Actor actor5;
	@Resource(name = "actorBean")
	private Actor actor6;

	@Resource(name = "filmBean")
	private Film film;
	@Resource(name = "filmBean")
	private Film film2;
	@Resource(name = "filmBean")
	private Film film3;

	@Resource(name = "filmBean")
	private Film film4;
	@Resource(name = "filmBean")
	private Film film5;
	@Resource(name = "filmBean")
	private Film film6;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2ManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Insert FILM
		film.setTitle("FilmBello");
		filmService.insertFilm(film);

		// Update FILM
		film.setFilmId(1);
		film.setTitle("FilmNonBello");
		filmService.updateFilm(film);

		// Delete FILM
//		filmService.deleteFilm(film.getFilmId());

		// Select FILM
		List<Film> films = filmService.getAllFilms();
		films.forEach(System.out::println);

		// Insert Actor
		actor.setFirstName("Manuel");
		actor.setLastName("Grapsi");
		actorService.insertActor(actor);

		// Update actor
		actor.setFirstName("LudovICo");
		actor.setLastName("Colucci");
		actorService.updateActor(actor);

		// Delete actor
//		actorService.deleteActor(actor.getActorId());

		// Select actors
		actorService.getAllActors().forEach(System.out::println);

		// Common

		// Insert relation
		filmActorService.insertActorFilmRelation(actor.getActorId(), film.getFilmId());

		// Insert actor with films

		List<Film> films2 = new ArrayList<>();
		film2.setTitle("Film2");
		film3.setTitle("Film3");
		films2.add(film2);
		films2.add(film3);
		actor2.setFirstName("Attore2");
		actor2.setLastName("Cognome2");
		filmActorService.insertActorWithFilms(actor2, films2);

		// Insert film with cast
		List<Actor> actors2 = new ArrayList<>();
		film4.setTitle("Film4");
		actor3.setFirstName("Attore3");
		actor3.setLastName("Cognome3");
		actor4.setFirstName("Attore4");
		actor4.setLastName("Cognome4");
		actors2.add(actor3);
		actors2.add(actor4);
		filmActorService.insertFilmWithActors(film4, actors2);

		// Attori da film x
		System.out.println("Lista di attori nel film4");
		filmActorService.getActorsByFilm(film4.getFilmId()).forEach(System.out::println);

		// Film di attore x
		System.out.println("Lista di film di actor2");
		filmActorService.getFilmsByActor(actor2.getActorId()).forEach(System.out::println);
	}

}
