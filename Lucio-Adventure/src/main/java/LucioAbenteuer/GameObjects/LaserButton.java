package LucioAbenteuer.GameObjects;
import LucioAbenteuer.Images;
import org.dyn4j.geometry.MassType;

public class LaserButton extends GameObject {
    public LaserButton(double x, double y) {
        super(Images.LASERBUTTTON, x, y);
        setMass(MassType.INFINITE);
    }
}
