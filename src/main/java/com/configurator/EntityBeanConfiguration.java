package com.configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.model.entity.Actor;
import com.model.entity.Film;

@Configuration
public class EntityBeanConfiguration {

	/*
	 * BEANS SU ACTOR
	 * 
	 */

	@Bean("actorBean")
	Actor getActorBean() {
		return new Actor();
	}

	/*
	 * BEANS SU FILM
	 */

	@Bean("filmBean")
	Film getFilmBean() {
		return new Film();
	}

}
