package br.com.pokemonwebflux.pokemon.config;

import br.com.pokemonwebflux.pokemon.handler.PokedexHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
//comentar quando usar flux
public class PokedexRouter {

    @Bean
    public RouterFunction<ServerResponse> route(PokedexHandler handler) {
        return RouterFunctions
                .route(GET("/pokedex").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/pokedex/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/pokedex/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
