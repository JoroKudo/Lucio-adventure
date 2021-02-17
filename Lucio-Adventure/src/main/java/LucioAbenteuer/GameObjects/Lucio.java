package LucioAbenteuer.GameObjects;

import LucioAbenteuer.*;
import javafx.scene.image.Image;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.World;

public class Lucio extends GameObject {

    private World<Body> physicWorld;
    private Direction currentDirect = Direction.RIGHT;
    private final KeyEventHandler keyEventHandler;

    public Lucio(double x, double y, World<Body> physicWorld, KeyEventHandler keyEventHandler) {
        super(Images.MARIORIGHT, x, y);
        this.physicWorld = physicWorld;
        this.keyEventHandler = keyEventHandler;

        setMass(MassType.NORMAL);
    }


    public void jump() {
        applyForce(new Vector2(0, -1500));
    }

    public void walkLeft() {
        currentDirect = Direction.LEFT;


        setLinearVelocity(-4, 0);

    }

    public void walkRight() {
        currentDirect = Direction.RIGHT;


        setLinearVelocity(4, 0);

    }

    public void handleNavigationEvents() {



        if (keyEventHandler.isRightKeyPressed() )
            walkRight();
        if (keyEventHandler.isLeftKeyPressed())
            walkLeft();




        if (isOnGround()) {
            if (keyEventHandler.isSpaceKeyPressed()) {
                jump();

            }
        }







    }



    public void update() {
        image = getCurrentImage();
    }

    private Image getCurrentImage() {
        if (isOnGround() && (currentDirect == Direction.LEFT)) {
            return Images.MARIOLEFT;
        } else if (isOnGround() && (currentDirect == Direction.RIGHT)) {
            return Images.MARIORIGHT;
        } else if (!isOnGround() && (currentDirect == Direction.RIGHT)) {
            return Images.LUCIO_JUMP_RIGHT;
        } else if (!isOnGround() && (currentDirect == Direction.LEFT)) {
            return Images.LUCIO_JUMP_LEFT;
        }
        throw new RuntimeException("No valid image found");
    }

    public boolean isOnGround() {
        for (Body body : physicWorld.getBodies()) {
            if (physicWorld.isInContact(this, body)) {
                if (!(body instanceof Lucio)) {
                    return true;
                }
            }
        }
        return false;
    }
}
