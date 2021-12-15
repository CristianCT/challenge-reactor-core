package com.example.demo.services;

import com.example.demo.CsvUtilFile;
import com.example.demo.Player;
import com.example.demo.models.PlayerModel;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Flux<PlayerModel> getAll(){
        return playerRepository.findAll().limitRequest(10);
    }
}
