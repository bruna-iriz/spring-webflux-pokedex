package br.com.pokemonwebflux.pokemon.handler;

import br.com.pokemonwebflux.pokemon.domain.Pokedex;
import br.com.pokemonwebflux.pokemon.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
//comentar quando usar flux - events stream
public class PokedexHandler {

    @Autowired
    PokedexService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Pokedex.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Pokedex.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Pokedex> pokedex = request.bodyToMono(Pokedex.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body((fromPublisher(
                        pokedex.flatMap(service::save),
                        Pokedex.class)));
    }
}
