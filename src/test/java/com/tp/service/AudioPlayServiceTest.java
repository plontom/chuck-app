package com.tp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

@SpringBootTest
class AudioPlayServiceTest {

    @Autowired
    AudioPlayService audioPlayService;

    @Test
    void play() {
        //given
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("aa.wav");
        //when, then
        audioPlayService.play(inputStream);
    }
}