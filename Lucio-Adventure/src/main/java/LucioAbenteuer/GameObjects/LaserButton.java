package LucioAbenteuer.GameObjects;

import LucioAbenteuer.Facility;
import LucioAbenteuer.Images;
import LucioAbenteuer.Rooms;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.world.World;

public class LaserButton extends GameObject {
    public LaserButton(double x, double y) {
        super(Images.LASERBUTTTON, x, y);
        setMass(MassType.INFINITE);

    }

}
