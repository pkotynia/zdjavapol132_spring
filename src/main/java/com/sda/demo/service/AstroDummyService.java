package com.sda.demo.service;

import com.sda.demo.model.AstroResult;
import com.sda.demo.model.Astronaut;
import com.sda.demo.service.AstroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AstroDummyService implements AstroService {

    @Override
    public Map<String, Long> getAstronautsCount() {
        return Map.of("Dummy craft", 0L);
    }
}
