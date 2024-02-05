package com.tp.service;

import com.tp.api.chuckNorrisJokes.ChuckNorrisJokesApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ChuckNorrisJokesServiceTest {

    @Autowired
    private ChuckNorrisJokesService chuckNorrisJokesService;

    @Test
    void randomJoke() throws IOException {
        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "Response is NULL");
    }

    @Test
    void getResponse() throws IOException {
        //given
        String url = "https://api.chucknorris.io/jokes/random";
        //when
        String response = chuckNorrisJokesService.getResponse(url);
        //then
        Assertions.assertNotNull(response, "Response is NULL");
    }
}