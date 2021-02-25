package LucioAbenteuer.GameObjects;

import LucioAbenteuer.Rooms;
import LucioAbenteuer.game.Facility;
import LucioAbenteuer.game.Images;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.world.World;

public class Door extends GameObject {
    public Door(double x, double y) {
        super(Images.DOOR, x, y);
        setMass(MassType.INFINITE);
    }

    public boolean leave(World<Body> physicWorld, Facility facility) {

        Rooms.room++;
        facility.lucio = new Lucio(6, 11.5, physicWorld, facility.keyEventHandler);
        physicWorld.removeAllBodies();
        physicWorld.addBody(facility.lucio);
        Rooms.roomchanges(Rooms.room, physicWorld);
        return false;
    }
}
