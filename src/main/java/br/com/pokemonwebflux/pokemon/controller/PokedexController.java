package br.com.pokemonwebflux.pokemon.controller;

import br.com.pokemonwebflux.pokemon.domain.Pokedex;
import br.com.pokemonwebflux.pokemon.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class PokedexController {

    @Autowired
    PokedexService service;

    @GetMapping(value = "/pokedex")
    public Flux<Pokedex> getPokedex() {
        return service.findAll();
    }

    @GetMapping(value = "/pokedex/{id}")
    public Mono<Pokedex> getPokedex(@PathVariable String Id) {
        return service.findById(Id);
    }

    @PostMapping(value = "/pokedex")
    public Mono<Pokedex> save(@RequestBody Pokedex pokedex) {
        return service.save(pokedex);
    }

    @GetMapping(value = "/pokedex/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Pokedex, Long>> getPokemonsByEvents() {

        Flux<Long> interval = Flux.interval(Duration.ofSeconds(03));
        Flux<Pokedex> events = service.findAll();
        System.out.println("LOOK AT THE EVENTS PASSING HERE!!!");
        return service.findAll().zipWith(interval);
    }
}

