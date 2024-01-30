package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.entity.Actor;
import com.repository.ActorRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;

public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository ar;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void insertActor(Actor actor) {
        try {
            ar.insertActor(actor);
            log.info("Actor inserted successfully");
        } catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
            e.printStackTrace();
            log.error("Error in insertActor()");
        }
    }

    @Override
    public void updateActor(Actor actor) {
        try {
            ar.updateActor(actor);
            log.info("Actor updated successfully");
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            e.printStackTrace();
            log.error("Error in updateActor()");
        }
    }

    @Override
    public void deleteActor(Integer actorId) {
        try {
            ar.deleteActor(actorId);
            log.info("Actor deleted successfully");
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            e.printStackTrace();
            log.error("Error in deleteActor()");
        }
    }

    @Override
    public Actor getActorById(Integer actorId) {
        Actor actor = null;
        try {
            actor = ar.getActorById(actorId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            log.error("Error in getActorById()");
        }

        return actor;
    }

    @Override
    public List<Actor> getAllActors() {
        List<Actor> actors = null;
        try {
            actors = ar.getAllActors();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            log.error("Error in getAllActors()");
        }

        return actors;
    }

}
