package com.tp.repository;

import com.tp.repository.entity.JokesEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JokesJpaRepositoryTest {
    @Autowired
    private JokesJpaRepository jokesJpaRepository;

    @Test
    void saveJoke() {
        //given
        JokesEntity jokesEntity = new JokesEntity();
        //when
        JokesEntity savedJokeEntity = jokesJpaRepository.save(jokesEntity);
        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedJokeEntity, "savedJpaEntity is NULL"),
                () -> Assertions.assertNotNull(savedJokeEntity.getId(), "savedJpaEntity is NULL")
        );
    }
}