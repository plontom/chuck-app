package com.tp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
public class AudioPlayService {

    public static final int BUFFER_SIZE = 4096;

    public boolean play(InputStream inputStream) {
        log.info("play(" + inputStream + ")");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);

            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            System.out.println("Playback Started.");

            byte[] bufferBytes = new byte[BUFFER_SIZE];
            int readBytes = -1;
            while ((readBytes = audioStream.read(bufferBytes)) != -1) {
                sourceDataLine.write(bufferBytes, 0, readBytes);
            }
            sourceDataLine.drain();
            sourceDataLine.close();
            audioStream.close();

            System.out.println("Playback has been finished.");

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            log.error("Unable to play sound", e);
        }
        log.info("play(...) = ");
        return false;
    }
}
