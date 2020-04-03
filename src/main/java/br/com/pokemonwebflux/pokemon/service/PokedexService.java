package br.com.pokemonwebflux.pokemon.service;

import br.com.pokemonwebflux.pokemon.domain.Pokedex;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PokedexService {

    Flux<Pokedex> findAll();

    Mono<Pokedex> findById(String id);

    Mono<Pokedex> save(Pokedex pokedex);
}
