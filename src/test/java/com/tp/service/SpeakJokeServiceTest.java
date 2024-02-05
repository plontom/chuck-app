package com.tp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpeakJokeServiceTest {

    @Autowired
    SpeakJokeService speakJokeService;

    @Test
    void speakJoke() {
        //when
        boolean spoken = speakJokeService.speakJoke();
        //then
        Assertions.assertTrue(spoken, "Joke not spoken");
    }
}