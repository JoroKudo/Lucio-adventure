package LucioAbenteuer.GameObjects;
import LucioAbenteuer.*;
import org.dyn4j.geometry.MassType;

public class CompanianCube extends GameObject {
    public CompanianCube(double x, double y) {
        super(Images.COMPANIAN, x, y);


        setMass(MassType.FIXED_ANGULAR_VELOCITY);



    }
}
