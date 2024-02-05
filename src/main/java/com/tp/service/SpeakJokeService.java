package com.tp.service;

import com.tp.api.chuckNorrisJokes.ChuckNorrisJokesApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class SpeakJokeService {

    private final ChuckNorrisJokesService chuckNorrisJokesService;
    private final VoiceRssService voiceRssService;

    public boolean speakJoke() {
        log.info("speakJoke()");
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        String joke = chuckNorrisJokesApiResponse.getValue();

        boolean spoken = voiceRssService.speakJoke(joke);
        log.info("speakJoke(...) = " + spoken);

        return spoken;
    }
}



