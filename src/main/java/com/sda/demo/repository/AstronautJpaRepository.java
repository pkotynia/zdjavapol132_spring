package com.sda.demo.repository;

import com.sda.demo.model.Astronaut;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
//@Profile("jpaRepo")
public interface AstronautJpaRepository extends JpaRepository<Astronaut, Integer> {

    List<Astronaut> getAllAstronautsByCraft(String craft);

    @Query(value = "SELECT a.craft, COUNT(*) FROM astronaut a GROUP BY a.craft", nativeQuery = true)
    List<Object[]> getNumberOfAstronautsPerCraft();

    // Object[0] -> craft:String Object[1] -> COUNT(*):Long
}
