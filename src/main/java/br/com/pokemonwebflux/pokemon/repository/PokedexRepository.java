package br.com.pokemonwebflux.pokemon.repository;

import br.com.pokemonwebflux.pokemon.domain.Pokedex;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokedexRepository extends ReactiveMongoRepository<Pokedex, String> {

}
