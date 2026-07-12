/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.PRUEBAaPICONSUMO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author luis
 */
@Service
public class CONSUMOaPI {

    private WebClient client;

    @Autowired
    public CONSUMOaPI(WebClient client) {
        this.client = client;
    }

    public Mono<String> postApi() {

        Mono<String> responses = client.post()
                .uri("")
                .exchangeToMono(response -> {

                    if (response.statusCode().value() == 200) {
                        return response.bodyToMono(String.class);
                    }

                    return response.bodyToMono(String.class);
                });

        return responses;
    }

    public Mono<jokeDtoRequest> getJokeById() {

        return client.get()
                .uri("https://api.chucknorris.io/jokes/random")
                .retrieve()
                .bodyToMono(jokeDtoRequest.class);

    }

    public Mono<List<String>> getCategories() {

        return client.get()
                .uri("https://api.chucknorris.io/jokes/categories")
                .retrieve()
                .bodyToFlux(String.class)
                .collectList();
    }

    public Mono<List<postDtoRq>> getPost() {

        return client.get()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .retrieve()
                .bodyToFlux(postDtoRq.class)
                .filter(post -> post.getTitle().toLowerCase().startsWith("q") && post.getId().startsWith("9"))
                .sort(Comparator.comparing(post -> post.getTitle()))
                .collectList();
    }

}
