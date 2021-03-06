package LucioAbenteuer.game;

import LucioAbenteuer.GameObjects.*;
import LucioAbenteuer.Rooms;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.World;

public class CollisionDetector {

    private final Facility facility;
    private final Score score;
    public HealthBar healthBar;
    private boolean isOpen = false;
    private Body body1;
    private Body body2;
    private World<Body> physicWorld;
    private boolean playSoundOnce = true;

    public CollisionDetector(Facility facility, Score score, HealthBar healthBar) {
        this.facility = facility;
        this.score = score;
        this.healthBar = healthBar;
    }

    public void handle(Body body1, Body body2, World<Body> physicWorld) {
        this.physicWorld = physicWorld;
        this.body1 = body1;
        this.body2 = body2;
        handleLucioCoin();
        handleLucioDoor();
        handleCubeButton();
        handleLucioPain();
        handleLucioHeart();
        handleLucioKey();
        handleCubeLaser();
        handleLaserButton();
    }

    public void handleLucioCoin() {
        if (body1 instanceof Lucio && body2 instanceof Coin) {
            Coin coin;
            coin = (Coin) body2;
            score.coinCounter = coin.collect(body2, physicWorld, score.coinCounter);
        }
    }

    public void handleLucioKey() {

        if (body1 instanceof Lucio && body2 instanceof Key) {
            Key key;
            key = (Key) body2;
            isOpen = key.open(body2, physicWorld);
        }
    }

    public void handleLucioHeart() {
        if (body1 instanceof Lucio && body2 instanceof Heart) {
            Heart heart;
            heart = (Heart) body2;
            healthBar.life = heart.heal(body2, physicWorld, healthBar.life);
        }
    }

    public void handleLaserButton() {
        if ((body1 instanceof CompanionCube && body2 instanceof LaserButton) || (body2 instanceof CompanionCube && body1 instanceof LaserButton)) {
            physicWorld.removeBody(Rooms.bl);
        }
    }

    public void handleLucioDoor() {
        if ((body1 instanceof Lucio && body2 instanceof Door && isOpen)) {
            Door door;
            door = (Door) body2;
            isOpen = door.leave(physicWorld, facility);
        }
    }

    public void handleCubeButton() {
        if ((body1 instanceof CompanionCube && body2 instanceof Button) || (body2 instanceof CompanionCube && body1 instanceof Button)) {
            Rooms.exitlight
                    .image = Images.LIGHTON;
            isOpen = true;
            if (playSoundOnce) {
                Sound.play(SoundEffectType.DOOR_OPEN);
                playSoundOnce = false;
            }
        }
    }

    public void handleLucioPain() {

        if ((body1 instanceof Lucio) && ((body2 instanceof Laser) || (body2 instanceof Spikes) || (body2 instanceof BigLaser))) {
            facility.lucio = new Lucio(6, 11.5, facility.physicWorld, facility.keyEventHandler);
            healthBar.life--;
            physicWorld.removeBody(body1);
            Sound.play(SoundEffectType.HURT);
            physicWorld.addBody(facility.lucio);
        }
    }

    public void handleCubeLaser() {

        if (body1 instanceof CompanionCube && body2 instanceof Laser) {
            CompanionCube companionCube;
            companionCube = (CompanionCube) body1;
            companionCube.shift(new Vector2(companionCube.getLinearVelocity().x + 1, 0));
        }
    }
}