package com.sda.demo.repository;

import com.sda.demo.model.Astronaut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AstronautJpaRepositoryTest {

    @Autowired
    private AstronautJpaRepository repository;

    @Test
    void shouldCountAstronauts() {
        assertEquals(3, repository.count());
    }

    @Test
    void shouldSaveAstronaut() {
        //when
        Astronaut han = repository.save(new Astronaut(null,  "Falcon Millennium", "Han Solo"));

        //then
        assertEquals("Falcon Millennium", han.getCraft());
    }

    @Test
    void shouldDelete(){
        repository.deleteById(1);

        assertEquals(2, repository.count());
    }

    @Test
    void shouldDeleteTwoAstronauts(){
        repository.deleteById(1);
        repository.deleteById(2);

        assertEquals(1, repository.count());
    }

    @Test
    void shouldFindAstronautsByCraft() {
        List<Astronaut> astronauts = repository.getAllAstronautsByCraft("Millennium Falcon");

        assertEquals(1, astronauts.size());
    }

    @Test
    void shouldReturnNumberOfAstronautsPerCraft() {
        List<Object[]> numberOfAstronautsPerCraft = repository.getNumberOfAstronautsPerCraft();

        Object[] objects = numberOfAstronautsPerCraft.get(0);

        assertEquals(3L, objects[1]);
    }
}