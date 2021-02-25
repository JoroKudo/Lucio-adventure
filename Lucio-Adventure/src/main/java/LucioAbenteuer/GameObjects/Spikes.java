package LucioAbenteuer.GameObjects;
import javafx.scene.image.Image;
import org.dyn4j.geometry.MassType;

public class Spikes extends GameObject {
    public Spikes(double x, double y, Image image) {
        super(image, x, y);
        setMass(MassType.INFINITE);

    }
}
