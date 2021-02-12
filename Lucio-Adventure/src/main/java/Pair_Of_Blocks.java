import org.dyn4j.geometry.MassType;

public class Pair_Of_Blocks extends GameObject {
    public Pair_Of_Blocks(double x, double y) {
        super(Images.PAIR_OF_BLOCKS, x, y);

        setMass(MassType.INFINITE);

    }
}
