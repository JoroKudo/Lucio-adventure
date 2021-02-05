import org.dyn4j.geometry.MassType;

public class Ground extends GameObject {
    public Ground(double x, double y) {
        super(Images.GROUND, x, y);

        setUserData("Ground");

        setMass(MassType.INFINITE);
    }
}
