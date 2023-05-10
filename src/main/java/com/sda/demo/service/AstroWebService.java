package com.sda.demo.service;

import com.sda.demo.model.AstroResult;
import com.sda.demo.service.AstroService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Primary
@Service
public class AstroWebService implements AstroService {

    private final RestTemplateBuilder builder;

    public AstroWebService(RestTemplateBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Map<String, Long> getAstronautsCount() {
        String url = "http://api.open-notify.org/astros.json";
        return builder.build().getForObject(url, AstroResult.class).people()
                .stream()
                .collect(Collectors.groupingBy(astronaut -> astronaut.getCraft(), Collectors.counting()));
//                .collect(Collectors
////                        .toMap(new Function<Astronaut, String>() {
////                                   @Override
////                                   public String apply(Astronaut o) {
////                                       return o.craft();
////                                   }
////                               },
//                                .toMap(
//                                        astronaut -> astronaut.craft(),
//                                        astronaut -> 1,
//                                        (valueExistingInMap, newValue) ->  valueExistingInMap + newValue
//                                )
//                );
    }
}


