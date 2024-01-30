package com.service;

import java.util.List;

import com.model.entity.Actor;

public interface ActorService {

    void insertActor(Actor actor);

    void updateActor(Actor actor);

    void deleteActor(Integer actorId);

    Actor getActorById(Integer actorId);

    List<Actor> getAllActors();

}
