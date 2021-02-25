package LucioAbenteuer.GameObjects;

import LucioAbenteuer.game.Images;
import org.dyn4j.geometry.MassType;

public class Button extends GameObject {
    public Button(double x, double y) {
        super(Images.BUTTON, x, y);
        setMass(MassType.INFINITE);
    }
}
