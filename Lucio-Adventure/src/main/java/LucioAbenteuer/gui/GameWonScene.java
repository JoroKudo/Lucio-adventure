package LucioAbenteuer.gui;

import LucioAbenteuer.common.BaseScene;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.Images;
import javafx.scene.input.KeyCode;

public class GameWonScene extends BaseScene {

    public GameWonScene(Navigator navigator) {
        super(navigator, Images.GAME_WON_BACKGROUND);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.goTo(SceneType.WELCOME);
            }
        });
    }
}
