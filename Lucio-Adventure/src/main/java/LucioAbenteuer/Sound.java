package LucioAbenteuer;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Sound {

    // Need to be a Instance-Variable for the music,
    // else the Garbage Collector stop the music.
    private static MediaPlayer musicPlayer;
    private final static Map<String, Media> cache = new HashMap<>();

    public static void play(MusicType music) {
        if (musicPlayer != null) {
            musicPlayer.stop();
        }
        musicPlayer = createMediaPlayer(getSoundFileName(music));

        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        musicPlayer.play();
    }

    public static void stop(MusicType music) {
        if (musicPlayer != null) {
            musicPlayer.stop();
        }
        musicPlayer = createMediaPlayer(getSoundFileName(music));
        musicPlayer.stop();
    }

    public static void play(SoundEffectType soundEffect) {
        MediaPlayer player = createMediaPlayer(getSoundFileName(soundEffect));
        player.play();
    }


    private static MediaPlayer createMediaPlayer(String filePath) {
        filePath = "/" + filePath;

        if (!cache.containsKey(filePath)) {
            URL url = Sound.class.getResource(filePath);
            if (url == null) {
                throw new RuntimeException("Could not load file: " + filePath);
            }

            cache.put(filePath, new Media(url.toString()));
        }

        return new MediaPlayer(cache.get(filePath));
    }

    private static String getSoundFileName(SoundEffectType soundEffect) {
        switch (soundEffect) {
            case HEAL:
                return "Heart.mp3";
            case DOOR_OPEN:
                return "DoorOpen.mp3";
            case HURT:
                return "Hurt.mp3";
            case COIN:
                return "Coin.mp3";
            default:
                throw new RuntimeException("No Soundfilename set for this enum value:" + soundEffect);
        }
    }

    private static String getSoundFileName(MusicType music) {
        switch (music) {
            case BACKGROUND:
                return "Lucio_BGM.mp3";
            case INTRO:
                return "MainMenu.wav";
            default:
                throw new RuntimeException("No Soundfilename set for this enum value:" + music);
        }
    }
}