package com.tp.controller;

import com.tp.service.VoiceRssService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class VoiceRssController {
    private final VoiceRssService voiceRssService;

    public boolean play(String textToVoice) {
        log.info("play(" + textToVoice + ")");
        boolean spoken = voiceRssService.speakJoke(textToVoice);
        log.info("play(...) = " + spoken);
        return spoken;
    }
}
