package LucioAbenteuer;



import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.common.Util;
import LucioAbenteuer.GameObjects.*;
import LucioAbenteuer.gui.SceneType;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.World;

import org.dyn4j.world.BroadphaseCollisionData;
import org.dyn4j.world.listener.CollisionListenerAdapter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game extends CopyOnWriteArrayList<GameObject> {

    public final KeyEventHandler keyEventHandler;
    private final Runnable gameLoopStopper;
    private final Navigator navigator;
    public final World<Body> physicWorld = new World<>();








    private GraphicsContext gc;

    private final Collision collisioner;

    public Game(KeyEventHandler keyEventHandler, Navigator navigator, Runnable gameLoopStopper) {
        this.keyEventHandler = keyEventHandler;
        this.gameLoopStopper = gameLoopStopper;
        this.collisioner = new Collision(this);
        this.navigator = navigator;

    }
    public Lucio lucio;



    public void draw(GraphicsContext gc) {

        gc.drawImage(Images.bgp, 0, 0);
        for (Body body : physicWorld.getBodies()) {
            GameObject gameObject = (GameObject) body;
            gameObject.draw(gc);
        }



        collisioner.score.draw(gc);
        collisioner.exitLight.draw(gc);
        collisioner.healthBar.draw(gc);
    }
    public void load(){

        lucio = new Lucio(11, 11, physicWorld,keyEventHandler);
        physicWorld.setGravity(new Vector2(0, 9.8));
        physicWorld.addBody(lucio);
        for (Body body : Rooms.createRoom(Rooms.testRoom)) {
            physicWorld.addBody(body);
        }


        physicWorld.addCollisionListener(new CollisionListenerAdapter<>() {
            @Override
            public boolean collision(BroadphaseCollisionData<Body, BodyFixture > collision) {
                Body body1 = collision.getBody1();
                Body body2 = collision.getBody2();
                collisioner.handle(body1,body2,physicWorld);




                return true;

            }


        });

    }

    public void update(double elapsedTime) {
        physicWorld.update(elapsedTime);
        lucio.handleNavigationEvents();



        lucio.getTransform().setRotation(0);
        lucio.update();
    }




    private void stop() {
        gameLoopStopper.run();
        clear();
    }
}
