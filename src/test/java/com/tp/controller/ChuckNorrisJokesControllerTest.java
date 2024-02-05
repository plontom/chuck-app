package com.tp.controller;

import com.tp.api.chuckNorrisJokes.ChuckNorrisJokesApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChuckNorrisJokesControllerTest {

    @Autowired
    private ChuckNorrisJokesController chuckNorrisJokesController;

    @Test
    void randomJoke() {
        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesController.randomJoke();
        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "Response is NULL");
    }
}