package com.example.demo.controllers;

import com.example.demo.models.PlayerModel;
import com.example.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public Flux<PlayerModel> getAll(){
        return playerService.getAll();
    }
}
