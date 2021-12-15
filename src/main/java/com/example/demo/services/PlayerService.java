package com.example.demo.services;

import com.example.demo.models.PlayerModel;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Objects;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Flux<PlayerModel> getAll(){
        return playerRepository.findAll().limitRequest(1000);
    }

    public Flux<PlayerModel> getByAge(int age) {
        return playerRepository.findAll()
                .limitRequest(1000)
                .buffer(100)
                .flatMap(player -> Flux.fromStream(player.parallelStream()))
                .filter(player -> player.getAge() > age);

    }

    public Flux<PlayerModel> getByClub(String club) {
        return playerRepository.findAll()
                .limitRequest(1000)
                .buffer(100)
                .flatMap(player -> Flux.fromStream(player.parallelStream()))
                .filter(playerNoNullClub -> Objects.nonNull(playerNoNullClub.getClub()))
                .filter(player -> player.getClub().equals(club));
    }

   public Flux<PlayerModel> getRanckingByNationality(String nationality) {
        return playerRepository.findAll()
                .limitRequest(1000)
                .buffer(100)
                .flatMap(player -> Flux.fromStream(player.parallelStream()))
                .filter(player -> player.getNational().equals(nationality))
                .sort(Comparator.comparingDouble(PlayerModel::getWinners).reversed());
    }
}
