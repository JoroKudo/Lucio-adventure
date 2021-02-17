package LucioAbenteuer;


import LucioAbenteuer.GameObjects.*;
import LucioAbenteuer.main.App;
import org.dyn4j.dynamics.Body;
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
    private int room = 1;
    private Body body1;
    private Body body2;
    private World<Body> physicWorld;


    public void handle(Body body1, Body body2, World<Body> physicWorld) {
        this.physicWorld = physicWorld;
        this.body1 = body1;
        this.body2 = body2;
        handleLucioCoin();
        handleLucioDoor();
        handleCubeButton();
        handleLucioLaser();

    }

    public boolean handleLucioCoin() {

        if (body1 instanceof Lucio && body2 instanceof Coin) {
            physicWorld.removeBody(body2);

            score.coinCounter++;

            return false;
        }

        if (body2 instanceof Lucio && body1 instanceof Coin) {
            physicWorld.removeBody(body1);

            score.coinCounter++;

            return false;
        }
        return true;
    }

    public boolean handleLucioDoor() {
        if ((body1 instanceof Lucio && body2 instanceof Door && isOpen) || (body2 instanceof Lucio && body1 instanceof Door && isOpen)) {

            room++;
            game.lucio = new Lucio(5, 11, game.physicWorld,game.keyEventHandler);
            physicWorld.removeAllBodies();
            physicWorld.addBody(game.lucio);
            Rooms.roomchanges(room, physicWorld);
            Images.bgp = Images.LVL2;
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


            return false;
        }
        return true;


    }

    public boolean handleLucioLaser() {

        if (body1 instanceof Lucio && body2 instanceof Laser) {
            healthBar.life--;
            game.lucio = new Lucio(5, 11, game.physicWorld,game.keyEventHandler);


            physicWorld.removeBody(body1);
            physicWorld.addBody(game.lucio);

            return false;
        }

        if (body2 instanceof Lucio && body1 instanceof Coin) {
            healthBar.life--;
            game.lucio = new Lucio(5, 11, game.physicWorld,game.keyEventHandler);



            physicWorld.removeBody(body2);
            physicWorld.addBody(game.lucio);

            return false;
        }

        return true;
    }

}

