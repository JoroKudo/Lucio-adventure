package LucioAbenteuer.GameObjects;

import LucioAbenteuer.Images;
import org.dyn4j.geometry.MassType;

public class Wall extends GameObject {
    public Wall(double x, double y) {
        super(Images.WALL, x, y);

        setMass(MassType.INFINITE);
    }
}
