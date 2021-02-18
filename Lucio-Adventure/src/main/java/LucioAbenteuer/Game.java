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
    public HealthBar healthBar;


    private GraphicsContext gc;

    private final Collision collisioner;

    public Game(KeyEventHandler keyEventHandler, Navigator navigator, Runnable gameLoopStopper) {
        this.keyEventHandler = keyEventHandler;
        this.gameLoopStopper = gameLoopStopper;
        this.collisioner = new Collision(this);
        this.navigator = navigator;

    }

    public Lucio lucio;
    public BallEnemy be;


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

    public void load() {
        healthBar = collisioner.healthBar;

        lucio = new Lucio(11, 11, physicWorld, keyEventHandler);
        be = new BallEnemy(20, 11, physicWorld);


        physicWorld.setGravity(new Vector2(0, 15));
        physicWorld.addBody(lucio);


        for (Body body : Rooms.createRoom(Rooms.testRoom)) {
            physicWorld.addBody(body);
        }


        physicWorld.addCollisionListener(new CollisionListenerAdapter<>() {
            @Override
            public boolean collision(BroadphaseCollisionData<Body, BodyFixture> collision) {
                Body body1 = collision.getBody1();
                Body body2 = collision.getBody2();
                collisioner.handle(body1, body2, physicWorld);


                return true;

            }


        });


    }



    public void update(double elapsedTime) {
        collisioner.handleBallEnemyMovement(elapsedTime);
        be.setLinearVelocity(be.x, be.getLinearVelocity().y);
        physicWorld.update(elapsedTime);
        lucio.handleNavigationEvents(elapsedTime);
        lucio.jump(elapsedTime);


        lucio.getTransform().setRotation(0);
        lucio.update();
        if (healthBar.life == 0) {
            navigator.goTo(SceneType.GAME_OVER);
        }

        if (collisioner.room == 6) {
            navigator.goTo(SceneType.GAME_WON);
        }

    }


    private void stop() {
        gameLoopStopper.run();
        clear();
    }
}
