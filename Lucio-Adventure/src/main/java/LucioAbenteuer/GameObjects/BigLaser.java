package LucioAbenteuer.GameObjects;
import LucioAbenteuer.game.Images;
import org.dyn4j.geometry.MassType;

public class BigLaser extends GameObject {
    public BigLaser(double x, double y) {
        super(Images.LASER, x, y);
        setMass(MassType.INFINITE);
    }
}
