package br.com.pokemonwebflux.pokemon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Pokedex {

    @Id
    private String id;
    private String name;
}
