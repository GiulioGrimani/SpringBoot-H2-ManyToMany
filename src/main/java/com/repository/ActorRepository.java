package com.repository;

import java.util.List;

import com.model.entity.Actor;

public interface ActorRepository {

	void insertActor(Actor actor);

	void updateActor(Actor actor);

	void deleteActor(Integer actorId);

	Actor getActorById(Integer actorId);

	List<Actor> getAllActors();
}
