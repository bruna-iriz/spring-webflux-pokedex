package br.com.pokemonwebflux.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonApplication.class, args);
        System.out.println("HELLO REACTIVE!");
    }
}
