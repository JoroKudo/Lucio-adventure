package LucioAbenteuer;



import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.common.Util;
import LucioAbenteuer.GameObjects.*;
import LucioAbenteuer.gui.SceneType;
import javafx.scene.canvas.GraphicsContext;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.world.World;

import org.dyn4j.world.BroadphaseCollisionData;
import org.dyn4j.world.listener.CollisionListenerAdapter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game extends CopyOnWriteArrayList<GameObject> {

    private final KeyEventHandler keyEventHandler;
    private final Runnable gameLoopStopper;
    private final Navigator navigator;
    public final World<Body> physicWorld = new World<>();


    public Lucio lucio = new Lucio(11, 11, physicWorld);





    private GraphicsContext gc;

    private final Collision collisioner;

    public Game(KeyEventHandler keyEventHandler, Navigator navigator, Runnable gameLoopStopper) {
        this.keyEventHandler = keyEventHandler;
        this.gameLoopStopper = gameLoopStopper;
        this.collisioner = new Collision(this);
        this.navigator = navigator;
    }



    public void draw(GraphicsContext gc) {
        for (Body body : physicWorld.getBodies()) {
            GameObject gameObject = (GameObject) body;
            gameObject.draw(gc);
        }
        collisioner.score.draw(gc);
        collisioner.exitLight.draw(gc);
        collisioner.healthBar.draw(gc);
    }

    public void update(double elapsedTime) {
        physicWorld.update(elapsedTime);
        gc.drawImage(Images.bgp, 0, 0);
        lucio.getTransform().setRotation(0);
        lucio.update();
    }
    public void collisionn(double deltaInSec) {
            physicWorld.addCollisionListener(new CollisionListenerAdapter<>() {
        @Override
        public boolean collision(BroadphaseCollisionData<Body, BodyFixture > collision) {
            Body body1 = collision.getBody1();
            Body body2 = collision.getBody2();
            collisioner.handle(body1,body2,physicWorld);




            return true;

        }


    });}



    private void stop() {
        gameLoopStopper.run();
        clear();
    }
}
