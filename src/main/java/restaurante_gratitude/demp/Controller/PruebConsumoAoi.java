/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import restaurante_gratitude.demp.PRUEBAaPICONSUMO.CONSUMOaPI;
import restaurante_gratitude.demp.PRUEBAaPICONSUMO.jokeDtoRequest;
import restaurante_gratitude.demp.PRUEBAaPICONSUMO.postDtoRq;

/**
 *
 * @author luis
 */
@RestController
public class PruebConsumoAoi {

    private CONSUMOaPI cONSUMOaPI;

    @Autowired
    public PruebConsumoAoi(CONSUMOaPI cONSUMOaPI) {
        this.cONSUMOaPI = cONSUMOaPI;
    }

    @GetMapping(value = "get/joke")
    public ResponseEntity<Mono<jokeDtoRequest>> getJoke() {

        return ResponseEntity.ok(cONSUMOaPI.getJokeById());
    }

    public ResponseEntity<Mono<List<String>>> getAllCat() {

        return ResponseEntity.ok(cONSUMOaPI.getCategories());
    }

    

    @GetMapping(value = "get/posts")
    public ResponseEntity<Mono<List<postDtoRq>>> getAllPost() {

        return ResponseEntity.ok(cONSUMOaPI.getPost());
    }

}
