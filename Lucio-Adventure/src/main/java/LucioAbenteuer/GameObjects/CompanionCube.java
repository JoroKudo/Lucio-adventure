package LucioAbenteuer.GameObjects;

import LucioAbenteuer.*;
import org.dyn4j.geometry.MassType;

public class CompanionCube extends GameObject {
    public CompanionCube(double x, double y) {
        super(Images.COMPANIAN, x, y);


        setMass(MassType.FIXED_ANGULAR_VELOCITY);


    }
}
