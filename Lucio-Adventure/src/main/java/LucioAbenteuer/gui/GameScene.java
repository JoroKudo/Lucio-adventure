package LucioAbenteuer.gui;

import LucioAbenteuer.common.BaseScene;
import LucioAbenteuer.common.FancyAnimationTimer;
import LucioAbenteuer.common.Initializable;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.KeyEventHandler;
import LucioAbenteuer.MusicType;
import LucioAbenteuer.Sound;
import LucioAbenteuer.Game;

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

        Game game = new Game(keyEventHandler, navigator, () -> gameLoop.stop());


        gameLoop = new FancyAnimationTimer() {
            @Override
            public void doHandle(double deltaInSec) {
                game.update(deltaInSec);
                game.draw(canvas.getGraphicsContext2D());
            }
        };
        gameLoop.start();
    }
}
