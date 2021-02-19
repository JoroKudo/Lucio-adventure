package LucioAbenteuer;


import LucioAbenteuer.GameObjects.*;
import LucioAbenteuer.gui.SceneType;
import LucioAbenteuer.main.App;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.PhysicsWorld;
import org.dyn4j.world.World;

public class CollisionDetector {

    public CollisionDetector(Game game) {
        this.game = game;
    }

    private Game game;

    public Score score = new Score();

    public HealthBar healthBar = new HealthBar();

    private boolean isOpen = true;
    public int room = 1;
    private Body body1;
    private Body body2;
    private World<Body> physicWorld;
    private boolean playSoundOnce = true;
    private double jumpCooldown;


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


    }

    public boolean handleLucioCoin() {

        if (body1 instanceof Lucio && body2 instanceof Coin) {
            physicWorld.removeBody(body2);
            Sound.play(SoundEffectType.COIN);
            score.coinCounter++;

            return false;
        }

        if (body2 instanceof Lucio && body1 instanceof Coin) {
            physicWorld.removeBody(body1);
            Sound.play(SoundEffectType.COIN);

            score.coinCounter++;

            return false;
        }
        return true;
    }


    public boolean handleLucioKey() {

        if (body1 instanceof Lucio && body2 instanceof Key) {
            physicWorld.removeBody(body2);
            Sound.play(SoundEffectType.KEY);

            isOpen = true;
            Rooms.exitlight
                    .image = Images.LIGHTON;

            return false;
        }

        if (body2 instanceof Lucio && body1 instanceof Key) {
            physicWorld.removeBody(body1);
            Sound.play(SoundEffectType.KEY);


            isOpen = true;
            Rooms.exitlight
                    .image = Images.LIGHTON;

            return false;
        }
        return true;
    }

    public boolean handleLucioHeart() {


        if (body1 instanceof Lucio && body2 instanceof Heart) {
            physicWorld.removeBody(body2);
            if (healthBar.life != 3) {


                healthBar.life++;
            }
            Sound.play(SoundEffectType.HEAL);
            return false;
        }

        if (body2 instanceof Lucio && body1 instanceof Heart) {
            physicWorld.removeBody(body1);

            if (healthBar.life != 3) {


                healthBar.life++;
            }
            Sound.play(SoundEffectType.HEAL);


            return false;
        }
        return true;
    }

    public boolean handleLucioDoor() {
        if ((body1 instanceof Lucio && body2 instanceof Door && isOpen) || (body2 instanceof Lucio && body1 instanceof Door && isOpen)) {

            room++;
            game.lucio = new Lucio(11, 7, game.physicWorld, game.keyEventHandler);


            physicWorld.removeAllBodies();
            physicWorld.addBody(game.lucio);
            isOpen = false;

            Rooms.roomchanges(room, physicWorld);


            return false;
        }
        return true;

    }

    public boolean handleCubeButton() {
        if ((body1 instanceof CompanianCube && body2 instanceof Button) || (body2 instanceof CompanianCube && body1 instanceof Button)) {

            System.out.println("activ");

            Rooms.exitlight
                    .image = Images.LIGHTON;
            isOpen = true;
            if (playSoundOnce) {
                Sound.play(SoundEffectType.DOOR_OPEN);
                playSoundOnce = false;
            }


            return false;

        }
        return true;


    }

    public boolean handleLucioPain() {

        if (body1 instanceof Lucio && body2 instanceof Laser || body2 instanceof Spikes && body1 instanceof Lucio) {
            game.lucio = new Lucio(11, 7, game.physicWorld, game.keyEventHandler);
            healthBar.life--;




            physicWorld.removeBody(body1);

            if (healthBar.life > 0 ){
                Sound.play(SoundEffectType.HURT);;}
            physicWorld.addBody(game.lucio);




            return false;
        }



        if (body2 instanceof Lucio && body1 instanceof Laser || body1 instanceof Spikes && body2 instanceof Lucio) {
            game.lucio = new Lucio(11, 7, game.physicWorld, game.keyEventHandler);

            healthBar.life--;


            physicWorld.removeBody(body2);
            physicWorld.addBody(game.lucio);
            if (healthBar.life == 0 ){
                Sound.stop(SoundEffectType.HURT);}

            return false;
        }

        return true;
    }
    public boolean handleCubeLaser() {

        if (body1 instanceof CompanianCube && body2 instanceof Laser) {






            physicWorld.removeBody(body1);

            if (healthBar.life > 0 ){
                Sound.play(SoundEffectType.HURT);;}
            physicWorld.addBody(game.lucio);




            return false;
        }
        return true;}


}

