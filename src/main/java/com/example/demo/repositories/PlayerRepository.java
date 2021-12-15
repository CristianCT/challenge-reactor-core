package com.example.demo.repositories;

import com.example.demo.models.PlayerModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayerRepository extends ReactiveMongoRepository<PlayerModel, String> {

}
