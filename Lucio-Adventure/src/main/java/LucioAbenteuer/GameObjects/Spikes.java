package LucioAbenteuer.GameObjects;
import LucioAbenteuer.*;
import org.dyn4j.geometry.MassType;

public class Spikes extends GameObject {
    public Spikes(double x, double y) {
        super(Images.SPIKES, x, y);
        setMass(MassType.INFINITE);

    }
}
