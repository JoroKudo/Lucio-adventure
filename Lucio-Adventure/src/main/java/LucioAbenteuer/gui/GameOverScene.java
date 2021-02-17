package LucioAbenteuer.gui;

import LucioAbenteuer.common.BaseScene;
import LucioAbenteuer.common.Initializable;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.Images;
import LucioAbenteuer.MusicType;
import LucioAbenteuer.Sound;
import LucioAbenteuer.SoundEffectType;
import javafx.scene.input.KeyCode;

public class GameOverScene extends BaseScene implements Initializable {

    public GameOverScene(Navigator navigator) {
        super(navigator, Images.GAME_OVER_BACKGROUND);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.goTo(SceneType.WELCOME);
            }
        });
    }

    @Override
    public void onInitialize() {
        Sound.stop(MusicType.BACKGROUND);
        Sound.play(SoundEffectType.SPACESHIP_EXPLODE);
    }
}
