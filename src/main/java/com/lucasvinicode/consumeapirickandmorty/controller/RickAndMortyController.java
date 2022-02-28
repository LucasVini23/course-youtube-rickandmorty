package com.lucasvinicode.consumeapirickandmorty.controller;

import com.lucasvinicode.consumeapirickandmorty.client.RickAndMortyClient;
import com.lucasvinicode.consumeapirickandmorty.response.CharacterResponse;
import com.lucasvinicode.consumeapirickandmorty.response.EpisodeResponse;
import com.lucasvinicode.consumeapirickandmorty.response.ListOfEpisodesResponse;
import com.lucasvinicode.consumeapirickandmorty.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {

    RickAndMortyClient rickAndMortyClient;

    //TODO: Tratamento de erro com exceptionHandler

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findAnCharacterById(id);
    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id) {
        return rickAndMortyClient.findAnLocationById(id);
    }

    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id) {
        return rickAndMortyClient.findAnEpisodeById(id);
    }

    @GetMapping("/episode/all")
    public Flux<ListOfEpisodesResponse> getAllEpisodes() {
        return rickAndMortyClient.getAllEpisodes();
    }

}
