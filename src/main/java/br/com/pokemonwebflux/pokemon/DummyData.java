package br.com.pokemonwebflux.pokemon;

import br.com.pokemonwebflux.pokemon.domain.Pokedex;
import br.com.pokemonwebflux.pokemon.repository.PokedexRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DummyData implements CommandLineRunner {

    private final PokedexRepository pokedexRepository;


    public void run(String... args) throws Exception {

        pokedexRepository.deleteAll()
                .thenMany(
                        Flux.just(
                                "Charizard",
                                "Bulbasaur",
                                "Ivysaur",
                                "Venusaur",
                                "Squirtle",
                                "Horsea",
                                "Chansey",
                                "Pikachu")
                                .map(name -> new Pokedex(UUID.randomUUID().toString(), name))
                                .flatMap(pokedexRepository::save))
                .subscribe(System.out::println);
    }
}
