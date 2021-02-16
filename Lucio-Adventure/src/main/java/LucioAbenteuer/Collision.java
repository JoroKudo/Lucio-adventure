package LucioAbenteuer;


import LucioAbenteuer.GameObjects.*;
import LucioAbenteuer.main.App;
import org.dyn4j.dynamics.Body;
import org.dyn4j.world.PhysicsWorld;
import org.dyn4j.world.World;

public class Collision {

    public Collision(App app) {
        this.app = app;
    }

    private Score score = new Score();
    private ExitLight exitLight = new ExitLight();
    private HealthBar healthBar = new HealthBar();
    private App app;
    private boolean isOpen = false;
    private int room = 1;
    private Body body1;
    private Body body2;
    private  World<Body> physicWorld;



    public void handle(Body body1,Body body2, World<Body> physicWorld) {
        this.physicWorld =physicWorld;
        this.body1 = body1;
        this.body2 =body2;
        handleLucioCoin();
        handleLucioDoor();
        handleCubeButton();

    }

    public Boolean handleLucioCoin() {

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
    public Boolean handleLucioDoor() {
        if ((body1 instanceof Lucio && body2 instanceof Door && isOpen)||(body2 instanceof Lucio && body1 instanceof Door && isOpen)) {

            room++;
            app.lucio = new Lucio(5, 11, physicWorld);
            physicWorld.removeAllBodies();
            physicWorld.addBody(app.lucio);
            Rooms.roomchanges(room, physicWorld);


            return false;
        }
        return true;

    }
    public Boolean handleCubeButton() {
        if ((body1 instanceof CompanianCube && body2 instanceof Button) ||(body2 instanceof CompanianCube && body1 instanceof Button)){
            System.out.println("activ");

            exitLight.image = Images.LIGHTON;
            isOpen = true;


            return false;
        }
        return true;


    }

    }

