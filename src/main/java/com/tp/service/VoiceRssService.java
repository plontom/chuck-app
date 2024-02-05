package com.tp.service;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class VoiceRssService {
    private static final String API_URL = "http://api.voicerss.org/?key=1234567890QWERTY&hl=en-us&src=Hello, world!";
    private AudioPlayService audioPlayService;
    private OkHttpClient client;

    public VoiceRssService(AudioPlayService audioPlayService) {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        this.audioPlayService = audioPlayService;
    }

    public boolean speakJoke(String textToVoice) {
        log.info("speakJoke(" + textToVoice + ")");
        boolean spoken = false;

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("api.voicerss.org")
                .addQueryParameter("key", "287f3ec6f19a47e881fc4e8ddbe009f3")
                .addQueryParameter("hl", "en-us")
                .addQueryParameter("src", textToVoice)
                .build();

        Request request = new Request.Builder().url(httpUrl).build();

        try (Response response = client.newCall(request).execute()) {
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                InputStream inputStream = new ByteArrayInputStream(responseBody.bytes());
                spoken = audioPlayService.play(inputStream);
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("speakJoke(...) = " + false);
        return spoken;
    }
}

