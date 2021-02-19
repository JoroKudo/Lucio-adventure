package LucioAbenteuer;


import LucioAbenteuer.GameObjects.*;
import org.dyn4j.dynamics.Body;
import org.dyn4j.world.World;

public class CollisionDetector {

    public CollisionDetector(Game game) {
        this.game = game;
    }

    private final Game game;

    public Score score = new Score();

    public HealthBar healthBar = new HealthBar();

    private boolean isOpen = true;
    public int room = 1;
    private Body body1;
    private Body body2;
    private World<Body> physicWorld;
    private boolean playSoundOnce = true;



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

    public void handleLucioCoin() {

        if (body1 instanceof Lucio && body2 instanceof Coin) {
            physicWorld.removeBody(body2);
            Sound.play(SoundEffectType.COIN);
            score.coinCounter++;

            return;
        }

        if (body2 instanceof Lucio && body1 instanceof Coin) {
            physicWorld.removeBody(body1);
            Sound.play(SoundEffectType.COIN);

            score.coinCounter++;

        }
    }


    public void handleLucioKey() {

        if (body1 instanceof Lucio && body2 instanceof Key) {
            physicWorld.removeBody(body2);
            Sound.play(SoundEffectType.KEY);

            isOpen = true;
            Rooms.exitlight
                    .image = Images.LIGHTON;

            return;
        }

        if (body2 instanceof Lucio && body1 instanceof Key) {
            physicWorld.removeBody(body1);
            Sound.play(SoundEffectType.KEY);


            isOpen = true;
            Rooms.exitlight
                    .image = Images.LIGHTON;

        }
    }

    public void handleLucioHeart() {


        if (body1 instanceof Lucio && body2 instanceof Heart) {
            physicWorld.removeBody(body2);
            if (healthBar.life != 3) {


                healthBar.life++;
            }
            Sound.play(SoundEffectType.HEAL);
            return;
        }

        if (body2 instanceof Lucio && body1 instanceof Heart) {
            physicWorld.removeBody(body1);

            if (healthBar.life != 3) {


                healthBar.life++;
            }
            Sound.play(SoundEffectType.HEAL);


        }
    }

    public void handleLucioDoor() {
        if ((body1 instanceof Lucio && body2 instanceof Door && isOpen) || (body2 instanceof Lucio && body1 instanceof Door && isOpen)) {

            room++;
            game.lucio = new Lucio(11, 7, game.physicWorld, game.keyEventHandler);


            physicWorld.removeAllBodies();
            physicWorld.addBody(game.lucio);
            isOpen = false;

            Rooms.roomchanges(room, physicWorld);


        }

    }

    public void handleCubeButton() {
        if ((body1 instanceof CompanionCube && body2 instanceof Button) || (body2 instanceof CompanionCube && body1 instanceof Button)) {

            System.out.println("activ");

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

        if (body1 instanceof Lucio && body2 instanceof Laser || body2 instanceof Spikes && body1 instanceof Lucio) {
            game.lucio = new Lucio(11, 7, game.physicWorld, game.keyEventHandler);
            healthBar.life--;




            physicWorld.removeBody(body1);

            if (healthBar.life > 0 ){
                Sound.play(SoundEffectType.HURT);}
            physicWorld.addBody(game.lucio);




            return;
        }



        if (body2 instanceof Lucio && body1 instanceof Laser || body1 instanceof Spikes && body2 instanceof Lucio) {
            game.lucio = new Lucio(11, 7, game.physicWorld, game.keyEventHandler);

            healthBar.life--;


            physicWorld.removeBody(body2);
            physicWorld.addBody(game.lucio);
            if (healthBar.life == 0 ){
                Sound.stop(SoundEffectType.HURT);}

        }

    }
    public boolean handleCubeLaser() {

        if (body1 instanceof CompanionCube && body2 instanceof Laser) {






            physicWorld.removeBody(body1);

            if (healthBar.life > 0 ){
                Sound.play(SoundEffectType.HURT);
            }
            physicWorld.addBody(game.lucio);




            return false;
        }
        return true;}


}

