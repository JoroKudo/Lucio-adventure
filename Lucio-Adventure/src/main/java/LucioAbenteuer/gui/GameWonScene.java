package LucioAbenteuer.gui;
import LucioAbenteuer.*;
import LucioAbenteuer.common.BaseScene;
import LucioAbenteuer.common.Initializable;
import LucioAbenteuer.common.Navigator;
import javafx.scene.input.KeyCode;

public class GameWonScene extends BaseScene implements Initializable {

    public GameWonScene(Navigator navigator) {
        super(navigator, Images.WIN);
        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                navigator.goTo(SceneType.WELCOME);
            }
        });
    }
    @Override
    public void onInitialize() {
        Sound.stop(MusicType.BACKGROUND);
        Sound.play(SoundEffectType.HEAL);
    }
}
