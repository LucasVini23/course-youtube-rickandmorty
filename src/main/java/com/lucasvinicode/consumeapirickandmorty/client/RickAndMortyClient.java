package com.lucasvinicode.consumeapirickandmorty.client;

import com.lucasvinicode.consumeapirickandmorty.response.CharacterResponse;
import com.lucasvinicode.consumeapirickandmorty.response.EpisodeResponse;
import com.lucasvinicode.consumeapirickandmorty.response.ListOfEpisodesResponse;
import com.lucasvinicode.consumeapirickandmorty.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class RickAndMortyClient {

    private final WebClient webClient;

    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findAnCharacterById(String id){
        log.info("buscando o personagem com o id [{}]", id);
        return webClient
                .get()
                .uri("/character/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique os parametros informados")))
                .bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findAnLocationById(String id){
        log.info("buscando a localizacao com o id [{}]", id);
        return webClient
                .get()
                .uri("/location/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique os parametros informados")))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findAnEpisodeById(String id){
        log.info("buscando o episodio com o id [{}]", id);
        return webClient
                .get()
                .uri("/episode/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique os parametros informados")))
                .bodyToMono(EpisodeResponse.class);
    }

    public Flux<ListOfEpisodesResponse> getAllEpisodes(){
        log.info("Listando todos os episodios");
        return webClient
                .get()
                .uri("/episode")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique os parametros informados")))
                .bodyToFlux(ListOfEpisodesResponse.class);
    }

}
