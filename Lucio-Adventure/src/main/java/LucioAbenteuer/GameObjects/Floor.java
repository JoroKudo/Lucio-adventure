package LucioAbenteuer.GameObjects;
import LucioAbenteuer.game.Images;
import org.dyn4j.geometry.MassType;

public class Floor extends GameObject {
    public Floor(double x, double y) {
        super(Images.FLOOR, x, y);
        setMass(MassType.INFINITE);
    }
}
