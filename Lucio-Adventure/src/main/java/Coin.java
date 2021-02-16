import org.dyn4j.geometry.MassType;

public class Coin extends GameObject {

    public Coin(double x, double y) {
        super(Images.COIN, x, y);

        setMass(MassType.INFINITE);

    }
}
