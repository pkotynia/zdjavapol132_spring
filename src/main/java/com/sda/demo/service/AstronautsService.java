package com.sda.demo.service;

import com.sda.demo.model.Astronaut;
import com.sda.demo.repository.AstronautJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AstronautsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AstronautsService.class);

    private final AstronautJpaRepository repository;

    public AstronautsService(AstronautJpaRepository repository) {
        this.repository = repository;
    }

    public Astronaut save(Astronaut astronaut) {
        return repository.save(astronaut);
    }

    public Iterable<Astronaut> getAllAstronauts() {
        return repository.findAll();
    }

    public Optional<Astronaut> getAstronautById(int id) {
        return repository.findById(id);
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }

    public List<Astronaut> getAstronautByCraft(String craft) {
        return repository.getAllAstronautsByCraft(craft);
    }

    public Map<String, Long> getNumberOfAstronautsByCraft() {
        List<Object[]> resultList = repository.getNumberOfAstronautsPerCraft();
        Map<String, Long> resultMap = new HashMap<>();
        for (Object[] objects : resultList) {
            resultMap.put(
                    (String) objects[0],
                    (Long) objects[1]
            );
        }
//        return repository.getNumberOfAstronautsPerCraft()
//                .stream()
//                .collect(
//                        Collectors.toMap(
//                                obj -> (String) obj[0], //this will produce Key for our map
//                                obj -> (Long) obj[1]) // this will produce Value
//                );
        return resultMap;
    }
}
