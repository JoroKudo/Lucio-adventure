package LucioAbenteuer.GameObjects;
import LucioAbenteuer.*;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.world.World;

public class Heart extends GameObject {

    public Heart(double x, double y) {
        super(Images.HEART, x, y);
        setMass(MassType.INFINITE);

    }
    public int heal(Body body, World<Body> physicWorld, int life) {

        if (life != 3) {
            life++;
        }
        Sound.play(SoundEffectType.HEAL);
        physicWorld.removeBody(body);
        return life;
    }
}
