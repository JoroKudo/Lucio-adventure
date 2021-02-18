package LucioAbenteuer.main;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.gui.*;
import javafx.application.Application;

import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage primaryStage) {
        Navigator navigator = new Navigator(primaryStage);
        navigator.registerScene(SceneType.WELCOME, new WelcomeScene(navigator));
        navigator.registerScene(SceneType.GAME, new GameScene(navigator));
        navigator.registerScene(SceneType.GAME_OVER, new GameOverScene(navigator));
        navigator.registerScene(SceneType.GAME_WON, new GameWonScene(navigator));
        navigator.goTo(SceneType.WELCOME);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}