package br.com.pokemonwebflux.pokemon.impl;

import br.com.pokemonwebflux.pokemon.service.PokedexService;
import br.com.pokemonwebflux.pokemon.domain.Pokedex;
import br.com.pokemonwebflux.pokemon.repository.PokedexRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PokedexServiceImpl implements PokedexService {

    private final PokedexRepository pokedexRepository;

    @Override
    public Flux<Pokedex> findAll() {
        return pokedexRepository.findAll();
    }

    @Override
    public Mono<Pokedex> findById(String id) {
        return findById(id);
    }

    @Override
    public Mono<Pokedex> save(Pokedex pokedex) {
        return save(pokedex);
    }

    public Flux<Pokedex> events(Pokedex pokedex) {
        return events(pokedex);
    }
}
