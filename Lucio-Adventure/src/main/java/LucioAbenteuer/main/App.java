package LucioAbenteuer.main;

import LucioAbenteuer.*;
import LucioAbenteuer.GameObjects.*;
import LucioAbenteuer.common.FancyAnimationTimer;
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

    public final World<Body> physicWorld = new World<>();


    public Lucio lucio = new Lucio(11, 11, physicWorld);
;




    private GraphicsContext gc;


    @Override
    public void start(Stage primaryStage) {
        Sound.play(MusicType.BACKGROUND);

        Group root = new Group();
        Canvas canvas = new Canvas(Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();


        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();



        physicWorld.setGravity(new Vector2(0, 9.8));
        physicWorld.addBody(lucio);

        for (Body body : Rooms.createRoom(Rooms.testRoom)) {
            physicWorld.addBody(body);
        }























    }



}