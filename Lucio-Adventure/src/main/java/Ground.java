import org.dyn4j.geometry.MassType;

public class Ground extends GameObject {
    public Ground(double x, double y) {
        super(Images.GROUND, x, y);

        setMass(MassType.INFINITE);

    }
}
