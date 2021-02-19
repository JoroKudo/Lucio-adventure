package LucioAbenteuer.GameObjects;

import LucioAbenteuer.*;
import org.dyn4j.geometry.MassType;

public class Key extends GameObject {

    public Key(double x, double y) {
        super(Images.KEY, x, y);

        setMass(MassType.INFINITE);

    }
}
