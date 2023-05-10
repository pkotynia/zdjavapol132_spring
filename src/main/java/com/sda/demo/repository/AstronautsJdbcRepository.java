package com.sda.demo.repository;

import com.sda.demo.model.Astronaut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
//@Profile("jdbcRepo")
public class AstronautsJdbcRepository implements CrudRepository<Astronaut, Integer> {

    private final JdbcTemplate jdbcTemplate;
    private static Logger LOGGER = LoggerFactory.getLogger(AstronautsJdbcRepository.class);

    public AstronautsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Astronaut> findAll() {
        LOGGER.info("find all method invoked");
        String query ="SELECT * FROM astronaut";
        RowMapper<Astronaut> rowMapper = getAstronautRowMapper();
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public <S extends Astronaut> S save(S entity) {
        SimpleJdbcInsert astronautInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("astronaut")
                .usingGeneratedKeyColumns("astronaut_id");

        Map<String, Object> params = new TreeMap<>();
        params.put("craft", entity.getCraft());
        params.put("name", entity.getName());

        Number id = astronautInsert.executeAndReturnKey(params);
        entity.setId(id.intValue());
        return entity;
    }

    private RowMapper<Astronaut> getAstronautRowMapper() {
        return (rs, rowNum) -> new Astronaut(
                rs.getInt("astronaut_id"),
                rs.getString("craft"),
                rs.getString("name")
        );
    }

    @Override
    public <S extends Astronaut> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Astronaut> findById(Integer integer) {
        String query = "SELECT * FROM astronaut WHERE astronaut_id=?";
        List<Astronaut> result = jdbcTemplate.query(query, getAstronautRowMapper(), integer);
        Astronaut astronaut = DataAccessUtils.singleResult(result);
        return Optional.ofNullable(astronaut);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Astronaut> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {
        jdbcTemplate.update("DELETE FROM astronaut WHERE astronaut_id=?", integer);
    }

    @Override
    public void delete(Astronaut entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Astronaut> entities) {

    }

    @Override
    public void deleteAll() {

    }

}
