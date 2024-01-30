package com;

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

	@Resource(name = "filmBean")
	private Film film;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2ManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		film.setTitle("FilmBello");
		filmService.insertFilm(film);

		film.setFilmId(1);
		film.setTitle("FilmNonBello");
		filmService.updateFilm(film);
	}

}
