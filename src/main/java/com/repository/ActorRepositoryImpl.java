package com.repository;

import java.util.List;

import com.model.entity.Actor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
public class ActorRepositoryImpl implements ActorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertActor(Actor actor) {
		entityManager.persist(actor);

	}

	@Override
	public void updateActor(Actor actor) {
		entityManager.merge(actor);

	}

	@Override
	public void deleteActor(Integer actorId) {
		Actor actorToRemove = getActorById(actorId);
		entityManager.remove(actorToRemove);
	}

	@Override
	public Actor getActorById(Integer actorId) {
		return entityManager.find(Actor.class, actorId);
	}

	@Override
	public List<Actor> getAllActors() {
		return entityManager.createNamedQuery("Actor.findAll", Actor.class).getResultList();
	}

}
