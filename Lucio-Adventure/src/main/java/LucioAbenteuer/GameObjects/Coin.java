package LucioAbenteuer.GameObjects;

import LucioAbenteuer.game.Images;
import LucioAbenteuer.game.Sound;
import LucioAbenteuer.game.SoundEffectType;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.world.World;

public class Coin extends GameObject {
    public Coin(double x, double y) {
        super(Images.COIN, x, y);
        setMass(MassType.INFINITE);
    }

    public int collect(Body body, World<Body> physicWorld, int money) {
        money++;
        Sound.play(SoundEffectType.COIN);
        physicWorld.removeBody(body);
        return money;
    }
}
