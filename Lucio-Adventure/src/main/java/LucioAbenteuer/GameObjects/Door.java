package LucioAbenteuer.GameObjects;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import LucioAbenteuer.*;
import org.dyn4j.world.World;

public class Door extends GameObject {
    private boolean isOpen = true;
    public Door(double x, double y) {
        super(Images.DOOR, x, y);

        setMass(MassType.INFINITE);

    }
    public boolean leave(Body body, World<Body> physicWorld, boolean isOpen, Facility facility){
        Rooms.room++;
        facility.lucio = new Lucio(11, 7, physicWorld, facility.keyEventHandler);


        physicWorld.removeAllBodies();
        physicWorld.addBody(facility.lucio);


        Rooms.roomchanges(Rooms.room++, physicWorld);
        return false;
    }
}
