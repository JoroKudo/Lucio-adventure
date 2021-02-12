import org.dyn4j.geometry.MassType;

public class Block extends GameObject {
    public Block(double x, double y) {
        super(Images.BLOCK, x, y);

        setMass(MassType.INFINITE);
    }
}
