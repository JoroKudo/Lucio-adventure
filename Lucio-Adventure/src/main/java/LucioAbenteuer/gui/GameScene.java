package LucioAbenteuer.gui;

import LucioAbenteuer.common.BaseScene;
import LucioAbenteuer.FancyAnimationTimer;
import LucioAbenteuer.common.Initializable;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.KeyEventHandler;
import LucioAbenteuer.MusicType;
import LucioAbenteuer.Sound;
import LucioAbenteuer.Space;

public class GameScene extends BaseScene implements Initializable {

    private FancyAnimationTimer gameLoop;

    public GameScene(Navigator navigator){
        super(navigator);
    }

    @Override
    public void onInitialize() {

        KeyEventHandler keyEventHandler = new KeyEventHandler();

        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);

        Sound.play(MusicType.BACKGROUND);

        Space space = new Space(keyEventHandler, navigator, () -> gameLoop.stop());
        space.load();

        gameLoop = new FancyAnimationTimer() {
            @Override
            public void doHandle(double deltaInSec) {
                space.update(deltaInSec);
                space.draw(canvas.getGraphicsContext2D());
            }
        };
        gameLoop.start();
    }
}
