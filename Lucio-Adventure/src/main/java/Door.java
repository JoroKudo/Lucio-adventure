import org.dyn4j.geometry.MassType;

public class Door extends GameObject {
    public Door(double x, double y) {
        super(Images.DOOR, x, y);

        setMass(MassType.INFINITE);

    }
}
