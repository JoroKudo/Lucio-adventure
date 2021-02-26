package LucioAbenteuer.gui;

import LucioAbenteuer.common.BaseScene;
import LucioAbenteuer.common.Initializable;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.game.Images;
import LucioAbenteuer.game.MusicType;
import LucioAbenteuer.game.Sound;
import javafx.scene.input.KeyCode;

public class GameOverScene extends BaseScene implements Initializable {

    public GameOverScene(Navigator navigator) {
        super(navigator, Images.GAMEOVER);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                navigator.goTo(SceneType.WELCOME);
            }
        });
    }

    @Override
    public void onInitialize() {

        Sound.play(MusicType.GAME_OVER);
    }
}
