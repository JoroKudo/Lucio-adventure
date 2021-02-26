package LucioAbenteuer.gui;

import LucioAbenteuer.common.BaseScene;
import LucioAbenteuer.common.FancyAnimationTimer;
import LucioAbenteuer.common.Initializable;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.game.*;

public class GameScene extends BaseScene implements Initializable {
    public GameScene(Navigator navigator) {
        super(navigator, Images.LVL1);
    }

    @Override
    public void onInitialize() {
        Images.bgp = Images.LVL1;
        KeyEventHandler keyEventHandler = new KeyEventHandler();
        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);
        Sound.play(MusicType.BACKGROUND);
        Facility facility = new Facility(keyEventHandler, navigator);
        facility.load();
        FancyAnimationTimer gameLoop = new FancyAnimationTimer() {
            @Override
            public void doHandle(double deltaInSec) {
                facility.update(deltaInSec)
                ;
                facility.draw(canvas.getGraphicsContext2D());

            }
        };
        gameLoop.start();
    }
}
