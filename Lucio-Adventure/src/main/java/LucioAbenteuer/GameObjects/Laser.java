package LucioAbenteuer.GameObjects;

import javafx.scene.image.Image;
import org.dyn4j.geometry.MassType;

public class Laser extends GameObject {

    public Laser(double x, double y, Image image) {
        super(image, x, y);
        setMass(MassType.INFINITE);
    }
}