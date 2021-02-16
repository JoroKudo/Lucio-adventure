package LucioAbenteuer.main;

import LucioAbenteuer.*;
import LucioAbenteuer.GameObjects.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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

    private final World<Body> physicWorld = new World<>();
    private Score score = new Score();
    private ExitLight exitLight = new ExitLight();
    private HealthBar healthBar = new HealthBar();
    public  Lucio lucio = new Lucio(11, 11, physicWorld);
    private Collision collisioner  = new Collision(this);
    private boolean isOpen = false;


    private GraphicsContext gc;


    @Override
    public void start(Stage primaryStage) {

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










        physicWorld.addCollisionListener(new CollisionListenerAdapter<>() {
            @Override
            public boolean collision(BroadphaseCollisionData<Body, BodyFixture> collision) {
                Body body1 = collision.getBody1();
                Body body2 = collision.getBody2();
                collisioner.handle(body1,body2,physicWorld);




                return true;

            }


        });









        scene.setOnKeyPressed(e -> {
            if (lucio.isOnGround()) {
                if (e.getCode() == KeyCode.SPACE) {
                    lucio.jump();

                }
            }
            if (e.getCode() == KeyCode.A) {
                lucio.walkLeft();
            }
            if (e.getCode() == KeyCode.D) {
                lucio.walkRight();
            }

        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                lucio.setLinearVelocity(0, 0);
            }
            if (e.getCode() == KeyCode.RIGHT) {
                lucio.setLinearVelocity(0, 0);
                System.out.println(lucio.getLinearVelocity());
            }
        });

        FancyAnimationTimer animationTimer = new FancyAnimationTimer() {
            @Override
            protected void doHandle(double elapsedTime) {
                physicWorld.update(elapsedTime);
                gc.drawImage(Images.GAME_BACKGROUND, 0, 0);
                lucio.getTransform().setRotation(0);
                lucio.update();




                for (Body body : physicWorld.getBodies()) {
                    GameObject gameObject = (GameObject) body;
                    gameObject.draw(gc);
                }
                score.draw(gc);
                exitLight.draw(gc);
                healthBar.draw(gc);

            }
        };

        animationTimer.start();

    }



}