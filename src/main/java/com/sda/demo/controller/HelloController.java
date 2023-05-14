package com.sda.demo.controller;
import com.sda.demo.service.AstroDummyService;
import com.sda.demo.service.AstroService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private AstroService astroService;

    public HelloController(@Qualifier("astroWebService") AstroService astroService) {
        this.astroService = astroService;
    }

    @GetMapping("/world")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/astro")
    public Map<String, Long> getAstronauts() {
        return astroService.getAstronautsCount();
    }
}
