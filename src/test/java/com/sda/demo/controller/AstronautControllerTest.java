package com.sda.demo.controller;

import com.sda.demo.model.Astronaut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AstronautControllerTest {

    @Test
    void getNonExistingAstronaut(@Autowired WebTestClient webTestClient){
        webTestClient
                .get()
                .uri("/astronauts/99")
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void shouldPostNewAstronaut(@Autowired WebTestClient webTestClient) {
        webTestClient
                .post()
                .uri("/astronauts")
                .bodyValue(new Astronaut(null, "Millennium Falcon","Han Solo"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Astronaut.class)
                .isEqualTo(new Astronaut(4,"Millennium Falcon","Han Solo" ));
    }

}