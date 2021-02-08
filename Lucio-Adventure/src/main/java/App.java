import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.dyn4j.collision.CollisionBody;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Mass;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Rectangle;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.BroadphaseCollisionData;
import org.dyn4j.world.ManifoldCollisionData;
import org.dyn4j.world.NarrowphaseCollisionData;
import org.dyn4j.world.World;
import org.dyn4j.dynamics.Body;
import org.dyn4j.world.listener.CollisionListener;
import org.dyn4j.world.listener.CollisionListenerAdapter;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private World<Body> physicWorld = new World<Body>();
    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Canvas canvas = new Canvas(Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        Mario mario = new Mario(10, 1);
        Ground ground = new Ground(10, 5);

        physicWorld.setGravity(new Vector2(0, 9.8));
        physicWorld.addBody(mario);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                mario.jump();
            }

            if (e.getCode() == KeyCode.A) {
                mario.setLinearVelocity(-100, 0);
            }

            if (e.getCode() == KeyCode.D) {
                mario.setLinearVelocity(100, 0);
            }
        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                mario.setLinearVelocity(0, 0);
            }

            if (e.getCode() == KeyCode.RIGHT) {
                mario.setLinearVelocity(0, 0);
                System.out.println(mario.getLinearVelocity());
            }
        });

        FancyAnimationTimer animationTimer = new FancyAnimationTimer() {
            @Override
            protected void doHandle(double elapsedTime) {
                physicWorld.update(elapsedTime);
                //gc.drawImage(Images.GAME_BACKGROUND, 0, 0);
                gc.clearRect(0,0, Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
                mario.draw(gc);
                ground.draw(gc);
            }
        };

        animationTimer.start();
    }
}