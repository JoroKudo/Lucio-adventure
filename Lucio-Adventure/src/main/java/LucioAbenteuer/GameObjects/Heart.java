package LucioAbenteuer.GameObjects;

import LucioAbenteuer.*;
import org.dyn4j.geometry.MassType;

public class Heart extends GameObject {

    public Heart(double x, double y) {
        super(Images.HEART, x, y);

        setMass(MassType.INFINITE);

    }
}
