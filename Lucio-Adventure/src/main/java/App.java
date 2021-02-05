import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.dyn4j.collision.CollisionBody;
import org.dyn4j.dynamics.BodyFixture;
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

    private World<Body>  physicWorld = new World<Body>();
    private GraphicsContext gc;
    private boolean isMarioinTouch = false;

    private  GameObject ground1;
    private Ground n[] = new Ground[300];

    @Override
    public void start(Stage primaryStage) {


        Group root = new Group();
        Canvas canvas = new Canvas(Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        physicWorld.addCollisionListener(new CollisionListener() {


            @Override
            public boolean collision(BroadphaseCollisionData collision) {

                isMarioinTouch = true;


                return true;
            }

            @Override
            public boolean collision(NarrowphaseCollisionData collision) {

                return true;
            }

            @Override
            public boolean collision(ManifoldCollisionData collision) {
                return true;
            }
        });
       /*
                addListener(new CollisionAdapter(){
            public boolean collision(Body body1, BodyFixture fixture1, Body body2,
                                     BodyFixture fixture2, Penetration penetration)
            { … }});*/

        GameObject mario = new Mario(0,0);



        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE&& isMarioinTouch){

                    isMarioinTouch = false;
                    mario.applyForce(new Vector2(0, 10 * Const.SCALE));



            }

            if (e.getCode() == KeyCode.A){
                mario.applyForce(new Vector2(-1  , 0));
                mario.setLinearVelocity(-6,0);

            }


            if (e.getCode() == KeyCode.D){
                mario.applyForce(new Vector2(1  , 0));
                mario.setLinearVelocity(6,0);

                System.out.println(mario.getLinearVelocity());
            }

        });
        scene.setOnKeyReleased(e -> {
            if (isMarioinTouch == true) {


                if (e.getCode() == KeyCode.LEFT) {

                    mario.setLinearVelocity(0, 0);

                }


                if (e.getCode() == KeyCode.RIGHT) {

                    mario.setLinearVelocity(0, 0);

                    System.out.println(mario.getLinearVelocity());
                }

            }});


        physicWorld.addBody(mario);
        for (int i = 0; i < 300; i++) {
            n[i] = new Ground(i,-10);
            physicWorld.addBody(n[i]);




        }



        FancyAnimationTimer animationTimer = new FancyAnimationTimer() {
            @Override
            protected void doHandle(double elapsedTime) {
                physicWorld.update(elapsedTime);

                gc.drawImage(Images.GAME_BACKGROUND, 0, 0);

                for (int i = 0; i < 300; i++) {

                    n[i].draw(gc);



                }

                mario.draw(gc);




            }
        };

        animationTimer.start();


    }

}
