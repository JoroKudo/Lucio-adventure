package LucioAbenteuer;


import LucioAbenteuer.GameObjects.*;
import LucioAbenteuer.gui.SceneType;
import LucioAbenteuer.main.App;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.PhysicsWorld;
import org.dyn4j.world.World;

public class Collision {

    public Collision(Game game) {
        this.game = game;
    }

    private Game game;

    public Score score = new Score();
    public ExitLight exitLight = new ExitLight();
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
            game.be = new BallEnemy(15, 14,game.physicWorld);

            physicWorld.removeAllBodies();
            physicWorld.addBody(game.lucio);

            Rooms.roomchanges(room, physicWorld);

            ExitLight.e = 55;



            return false;
        }
        return true;

    }

    public boolean handleCubeButton() {
        if ((body1 instanceof CompanianCube && body2 instanceof Button) || (body2 instanceof CompanianCube && body1 instanceof Button)) {

            System.out.println("activ");

            exitLight.image = Images.LIGHTON;
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

        if (body1 instanceof Lucio && body2 instanceof Laser ||body2 instanceof Spikes && body1 instanceof Lucio) {
            healthBar.life--;
            game.lucio = new Lucio(11, 7, game.physicWorld, game.keyEventHandler);


            physicWorld.removeBody(body1);
            Sound.play(SoundEffectType.HURT);
            physicWorld.addBody(game.lucio);

            return false;
        }

        if (body2 instanceof Lucio && body1 instanceof Laser||body1 instanceof Spikes &&body2 instanceof Lucio) {
            healthBar.life--;
            game.lucio = new Lucio(11, 7, game.physicWorld, game.keyEventHandler);


            physicWorld.removeBody(body2);
            physicWorld.addBody(game.lucio);

            return false;
        }

        return true;
    }



    public boolean handleBallEnemyMovement(double deltaInSec) {



        if (body1 instanceof BallEnemy && body2 instanceof Lucio && jumpCooldown > 1 ||body2 instanceof Wall&& jumpCooldown > 1||body1 instanceof BallEnemy && body2 instanceof Button && jumpCooldown > 1) {

                jumpCooldown = 0;


            game.be.x = -game.be.x;




            return false;
        }
    else {
        jumpCooldown +=  deltaInSec;
    }

        if (body2 instanceof BallEnemy && body1 instanceof Lucio ||body1 instanceof Wall) {
            game.be.x = -game.be.x;





            return false;
        }

        return true;
    }


}

