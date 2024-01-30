package com.service;

import java.util.List;

public interface ActorService {

    void insertActor(Actor actor);

    void updateActor(Actor actor);

    void deleteActor(Integer actorId);

    Actor getActorById(Integer actorId);

    List<Actor> getAllActors();

}
