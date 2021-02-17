package LucioAbenteuer.main;

import LucioAbenteuer.*;
import LucioAbenteuer.GameObjects.*;
import LucioAbenteuer.common.FancyAnimationTimer;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.gui.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.BroadphaseCollisionData;
import org.dyn4j.world.World;
import org.dyn4j.dynamics.Body;
import org.dyn4j.world.listener.CollisionListenerAdapter;



import javafx.scene.paint.Color;

public class App extends Application {



    @Override
    public void start(Stage primaryStage) {
        Navigator navigator = new Navigator(primaryStage);
        navigator.registerScene(SceneType.WELCOME, new WelcomeScene(navigator));
        navigator.registerScene(SceneType.GAME, new GameScene(navigator));
        navigator.registerScene(SceneType.GAME_OVER, new GameOverScene(navigator));
        navigator.registerScene(SceneType.GAME_WON, new GameWonScene(navigator));

        navigator.goTo(SceneType.WELCOME);

        Sound.play(MusicType.BACKGROUND);



        primaryStage.setMaximized(true);
        primaryStage.show();





























    }



}