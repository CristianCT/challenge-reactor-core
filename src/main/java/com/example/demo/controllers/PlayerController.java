package com.example.demo.controllers;

import com.example.demo.models.PlayerModel;
import com.example.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public Flux<PlayerModel> getAll(){
        return playerService.getAll();
    }

    @GetMapping("/age/34")
    public Flux<PlayerModel> getByAge(){
        return playerService.getByAge(34);
    }

    @GetMapping("/club/{name}")
    public Flux<PlayerModel> getByClub(@PathVariable("name") String club){
        return playerService.getByClub(club);
    }

    @GetMapping("/rancking/{nationality}")
    public Flux<PlayerModel> getRanckingByNationality(@PathVariable("nationality") String nationality){
        return playerService.getRanckingByNationality(nationality);
    }
}
