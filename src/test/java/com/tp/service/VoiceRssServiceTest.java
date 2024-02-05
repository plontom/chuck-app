package com.tp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class VoiceRssServiceTest {

    @Autowired
    VoiceRssService voiceRssService;

    @Test
    void speakJoke() throws IOException {
        //when
        boolean spoken = voiceRssService.speakJoke("Hello Joke!");
        //then
        Assertions.assertTrue(spoken, "Not spoken");
    }
}