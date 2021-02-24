package LucioAbenteuer.gui;
import LucioAbenteuer.common.BaseScene;
import LucioAbenteuer.common.Initializable;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.Images;
import LucioAbenteuer.MusicType;
import LucioAbenteuer.Sound;
import javafx.scene.input.KeyCode;

public class WelcomeScene extends BaseScene implements Initializable {

    public WelcomeScene(Navigator navigator) {
        super(navigator, Images.MAINMENU);
        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                navigator.goTo(SceneType.GAME);
            }
        });
    }
    @Override
    public void onInitialize() {
        Sound.play(MusicType.INTRO);
    }
}
