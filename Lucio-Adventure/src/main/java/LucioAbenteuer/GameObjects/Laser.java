package LucioAbenteuer.GameObjects;


import LucioAbenteuer.*;
import org.dyn4j.geometry.MassType;

public class Laser extends GameObject {
    public Laser(double x, double y) {
        super(Images.LASER_BEAM, x, y);

        setMass(MassType.INFINITE);

    }
}
