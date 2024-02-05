package com.tp.service;

import com.google.gson.Gson;
import com.tp.api.chuckNorrisJokes.ChuckNorrisJokesApiResponse;
import com.tp.repository.JokesJpaRepository;
import com.tp.repository.entity.JokesEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChuckNorrisJokesService {

    private static final String API_URL = "https://api.chucknorris.io/jokes/random";
    private final JokesJpaRepository jokesJpaRepository;
    private OkHttpClient client = new OkHttpClient();

    public ChuckNorrisJokesApiResponse randomJoke() {
        log.info("randomJoke()");
        try {
            String responseBody = getResponse(API_URL);
            ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = convert(responseBody);
            String joke = chuckNorrisJokesApiResponse.getValue();
            JokesEntity jokeEntity = new JokesEntity();
            jokeEntity.setJoke(joke);
            JokesEntity savedJokeEntity = jokesJpaRepository.save(jokeEntity);
            log.info("savedJokeEntity: " + savedJokeEntity);

            log.info("randomJoke(...) = " + chuckNorrisJokesApiResponse);
            return chuckNorrisJokesApiResponse;
        } catch (IOException e) {
            log.error("Unable to connect with external API.", e);
        }
        log.info("randomJoke() = " + null);
        return null;
    }

    public String getResponse(String url) throws IOException {
        log.info("getResponse(" + url + ")");
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String body = response.body().string();
            log.info("getResponse() = " + body);
            return body;
        }
    }

    public ChuckNorrisJokesApiResponse convert(String body) {
        log.info("convert(" + body + ")");
        Gson gson = new Gson();
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = gson.fromJson(body, ChuckNorrisJokesApiResponse.class);
        log.info("convert(...) = " + chuckNorrisJokesApiResponse);
        return chuckNorrisJokesApiResponse;
    }
}
