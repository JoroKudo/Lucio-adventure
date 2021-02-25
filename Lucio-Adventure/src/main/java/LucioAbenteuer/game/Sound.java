package LucioAbenteuer.game;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Sound {
    private static MediaPlayer musicPlayer;
    private static MediaPlayer effectPlayer;
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
        effectPlayer = createMediaPlayer(getSoundFileName(soundEffect));
        effectPlayer.play();
    }
    private static MediaPlayer createMediaPlayer(String filePath) {
        filePath = "/Sound/" + filePath;

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
        return switch (soundEffect) {
            case HEAL -> "Heart.mp3";
            case DOOR_OPEN -> "DoorOpen.mp3";
            case HURT -> "Hurt.mp3";
            case COIN -> "Coin.mp3";
            case KEY -> "Key.mp3";

        };
    }
    private static String getSoundFileName(MusicType music) {
        return switch (music) {
            case BACKGROUND -> "Lucio_BGM.mp3";
            case INTRO -> "MainMenu.wav";
            case GAME_OVER -> "gameOver.mp3";
        };
    }
}