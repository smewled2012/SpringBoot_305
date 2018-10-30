package com.example.demo.movieRepository;

import com.example.demo.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor,Long> {
}
