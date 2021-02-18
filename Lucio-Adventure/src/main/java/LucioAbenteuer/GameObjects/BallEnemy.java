package LucioAbenteuer.GameObjects;

import LucioAbenteuer.*;
import javafx.scene.image.Image;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.World;

public class BallEnemy extends GameObject {


    private World<Body> physicWorld;
    public int x = 4;





    public BallEnemy(double x, double y, World<Body> physicWorld) {
        super(Images.BALL_ENEMY, x, y);

        this.physicWorld = physicWorld;


        setMass(MassType.NORMAL);



    }


    public void walkLeft() {










    }

    public void walkRight() {


        setLinearVelocity(x, getLinearVelocity().y);


    }
}