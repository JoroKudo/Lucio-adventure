package LucioAbenteuer.game;

import LucioAbenteuer.GameObjects.GameObject;
import LucioAbenteuer.GameObjects.Lucio;
import LucioAbenteuer.Rooms;
import LucioAbenteuer.common.Navigator;
import LucioAbenteuer.gui.SceneType;
import javafx.scene.canvas.GraphicsContext;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.BroadphaseCollisionData;
import org.dyn4j.world.World;
import org.dyn4j.world.listener.CollisionListenerAdapter;

import java.util.concurrent.CopyOnWriteArrayList;

public class Facility extends CopyOnWriteArrayList<GameObject> {

    public Lucio lucio;
    public final KeyEventHandler keyEventHandler;
    public final World<Body> physicWorld = new World<>();
    private final Navigator navigator;
    private final Score score = new Score();
    private final HealthBar healthBar = new HealthBar();
    private final CollisionDetector collision;
    //RoomChanger
    private double switchcooler = 1;

    public Facility(KeyEventHandler keyEventHandler, Navigator navigator) {
        this.keyEventHandler = keyEventHandler;
        this.collision = new CollisionDetector(this, score, healthBar);
        this.navigator = navigator;
    }

    public void draw(GraphicsContext gc) {

        gc.drawImage(Images.bgp, 0, 0);
        for (Body body : physicWorld.getBodies()) {
            GameObject gameObject = (GameObject) body;
            gameObject.draw(gc);
        }
        score.draw(gc);
        Rooms.exitlight.draw(gc);
        healthBar.draw(gc);
    }

    public void load() {

        lucio = new Lucio(10, 11, physicWorld, keyEventHandler);
        physicWorld.setGravity(new Vector2(0, 15));
        physicWorld.addBody(lucio);
        for (Body body : Rooms.createRoom(Rooms.room1)) {
            physicWorld.addBody(body);
        }
        physicWorld.addCollisionListener(new CollisionListenerAdapter<>() {
            @Override
            public boolean collision(BroadphaseCollisionData<Body, BodyFixture> collision) {
                Body body1 = collision.getBody1();
                Body body2 = collision.getBody2();
                Facility.this.collision.handle(body1, body2, physicWorld);
                return true;
            }


        });
    }

    public void update(double elapsedTime) {

        physicWorld.update(elapsedTime);
        lucio.handleNavigationEvents();
        lucio.jump(elapsedTime);
        lucio.getTransform().setRotation(0);
        lucio.update();
        if (healthBar.life == 0) {
            physicWorld.removeAllBodies();
            navigator.goTo(SceneType.GAME_OVER);
            healthBar.life++;
        }
        if (Rooms.room > 5) {
            physicWorld.removeAllBodies();
            navigator.goTo(SceneType.GAME_WON);
            Rooms.room = 1;
        }
        if ((keyEventHandler.isOPressed() || keyEventHandler.isPPressed()) && switchcooler > 1) {
            if (keyEventHandler.isOPressed()) {
                Rooms.room--;
                lucio = new Lucio(6, 11.5, physicWorld, keyEventHandler);
                physicWorld.removeAllBodies();
                physicWorld.addBody(lucio);
                Rooms.roomchanges(Rooms.room, physicWorld);
                switchcooler = 0;
            }
            if (keyEventHandler.isPPressed()) {
                Rooms.room++;
                lucio = new Lucio(6, 11.5, physicWorld, keyEventHandler);
                physicWorld.removeAllBodies();
                physicWorld.addBody(lucio);
                Rooms.roomchanges(Rooms.room, physicWorld);
                switchcooler = 0;
            }
        } else {
            switchcooler += 10 * elapsedTime;
        }

    }
}

