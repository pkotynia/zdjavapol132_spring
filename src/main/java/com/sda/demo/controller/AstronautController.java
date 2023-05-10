package com.sda.demo.controller;

import com.sda.demo.model.Astronaut;
import com.sda.demo.service.AstronautsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/astronauts")
public class AstronautController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AstronautController.class);

    private AstronautsService astronautsService;

    public AstronautController(AstronautsService astronautsService) {
        this.astronautsService = astronautsService;
    }

    @PostMapping
    public ResponseEntity<Astronaut> postAstronaut(@RequestBody Astronaut requestAstronaut) {
        Astronaut savedAstronaut = astronautsService.save(requestAstronaut);
        LOGGER.info("{} saved", savedAstronaut);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedAstronaut);
    }

    @GetMapping
    public Iterable<Astronaut> getAllAstronauts() {
        return astronautsService.getAllAstronauts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Astronaut> getAstronautByName(@PathVariable int id) {
        LOGGER.info("getting object with id {}", id);
        Optional<Astronaut> response = astronautsService.getAstronautById(id);
        return response
                .map(astronautResponse -> ResponseEntity.ok(astronautResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());

        /*
        if(response.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(response.get());
        }*/
    }

    @GetMapping("/craft")
    public List<Astronaut> getAstronautsByCraft(@RequestParam String name){
        return astronautsService.getAstronautByCraft(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExample(@PathVariable int id) {
        if(astronautsService.getAstronautById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            astronautsService.removeById(id);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/per_craft")
    public Map<String, Long> getNumberOfAstronautsPerCraft() {
        return astronautsService.getNumberOfAstronautsByCraft();
    }

}
