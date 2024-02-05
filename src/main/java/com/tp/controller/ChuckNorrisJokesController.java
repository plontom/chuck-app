package com.tp.controller;

import com.tp.api.chuckNorrisJokes.ChuckNorrisJokesApiResponse;
import com.tp.service.ChuckNorrisJokesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/jokes")
public class ChuckNorrisJokesController {

    private final ChuckNorrisJokesService chuckNorrisJokesService;

    @GetMapping
    public String jokeView() {
        log.info("jokeView()");
        return "jokes.html";
    }

    @PostMapping
    public String joke(ModelMap modelMap) {
        log.info("joke()");
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = randomJoke();
        modelMap.addAttribute("joke", chuckNorrisJokesApiResponse.getValue());
        log.info("joke(...)" + chuckNorrisJokesApiResponse.getValue());
        return "jokes.html";
    }

    public ChuckNorrisJokesApiResponse randomJoke() {
        log.info("randomJoke()");
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        log.info("randomJoke(...) = " + chuckNorrisJokesApiResponse);
        return chuckNorrisJokesApiResponse;
    }
}
