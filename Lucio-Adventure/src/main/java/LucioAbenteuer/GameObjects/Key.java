package LucioAbenteuer.GameObjects;
import LucioAbenteuer.*;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.world.World;

public class Key extends GameObject {

    public Key(double x, double y) {
        super(Images.KEY, x, y);
        setMass(MassType.INFINITE);
    }
    public boolean open(Body body, World<Body> physicWorld, boolean isOpen) {

        physicWorld.removeBody(body);
        Sound.play(SoundEffectType.KEY);
        isOpen = true;
        Rooms.exitlight
                .image = Images.LIGHTON;
        return isOpen;
    }
}
