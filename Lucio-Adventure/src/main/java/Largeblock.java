import org.dyn4j.geometry.MassType;

public class Largeblock extends GameObject {
    public Largeblock(double x, double y) {
        super(Images.PAIR_OF_BLOCKS, x, y);

        setMass(MassType.INFINITE);

    }
}
