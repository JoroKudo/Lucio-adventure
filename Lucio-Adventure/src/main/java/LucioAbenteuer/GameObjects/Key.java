package LucioAbenteuer.GameObjects;

import LucioAbenteuer.Rooms;
import LucioAbenteuer.game.Images;
import LucioAbenteuer.game.Sound;
import LucioAbenteuer.game.SoundEffectType;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.world.World;

public class Key extends GameObject {

    public Key(double x, double y) {
        super(Images.KEY, x, y);
        setMass(MassType.INFINITE);
    }

    public boolean open(Body body, World<Body> physicWorld) {

        physicWorld.removeBody(body);
        Sound.play(SoundEffectType.KEY);

        Rooms.exitlight.image = Images.LIGHTON;
        return true;
    }
}
