import org.dyn4j.geometry.MassType;

public class Block extends GameObject {
    public Block(double x, double y) {
        super(Images.ROW_OF_BLOCKS, x, y);

        setMass(MassType.INFINITE);


    }
}
