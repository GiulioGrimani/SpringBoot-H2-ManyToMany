package com.configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.model.entity.Actor;
import com.model.entity.Film;

@Configuration
public class EntityBeanConfiguration {

	/*
	 * BEANS SU ACTOR
	 * 
	 */

	@Scope("prototype")
	@Bean("actorBean")
	Actor getActorBean() {
		return new Actor();
	}

	/*
	 * BEANS SU FILM
	 */
	@Scope("prototype")
	@Bean("filmBean")
	Film getFilmBean() {
		return new Film();
	}

}
