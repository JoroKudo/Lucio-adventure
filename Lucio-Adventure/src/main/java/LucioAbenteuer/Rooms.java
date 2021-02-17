package LucioAbenteuer;

import org.dyn4j.dynamics.Body;
import org.dyn4j.world.PhysicsWorld;
import LucioAbenteuer.GameObjects.*;

import java.util.ArrayList;
import java.util.List;

public class Rooms {


    public static String room1 =
                    "0000000000000L0000000000000000" +
                    "0000000000000L0000000000000000" +
                    "0000000000000L0000000000000000" +
                    "0000000000000L0000000000000000" +
                    "0000000000000L0000000000000000" +
                    "0000000000000L000D000000000000" +
                    "0C0000000C000L00BBB00000000000" +
                    "0000000000000LBBBBBBB000000000" +
                    "0000000000000L0C0C0C0C0C000000" +
                    "BBB0000BBBB00L0000000000000000" +
                    "0000000000000L000000000000000C" +
                    "0000000000000BBBBBBBBBBBB00000" +
                    "000000000000000000000000000000" +
                    "0000000000000000000000000000BB" +
                    "000000000000000000000000000000" +
                    "00F00000000000FF000000000000F0";

    public static String testRoom =
                    "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "WC0000C0000000D00000000000000W" +
                    "W0000000000BBBBBBB00000000000W" +
                    "W00000000000C0C0C0C0000C00000W" +
                    "WBB0BBBB000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W00000000000000000000000R0000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0K00000000000000000000000000W"+
                    "WBBB0000000000000FF0000000000W" ;



    public static List<Body> createRoom(String roomname) {
        final double ROW_LENGHT = 30;
        ArrayList<Body> bodiesFromRoom = new ArrayList<>();
        for (int i = 1; i < roomname.length() - 1; i++) {
            char symb = roomname.charAt(i);
            double y = (int) (i / ROW_LENGHT);
            double x = i % ROW_LENGHT;
            switch (symb) {
                case 'B' -> bodiesFromRoom.add(new Block(x, y));
                case 'W' -> bodiesFromRoom.add(new Wall(x, y));


                case 'C' -> bodiesFromRoom.add(new Coin(x, y));


                case 'F' -> bodiesFromRoom.add(new Floor(x, y));


                case 'D' -> bodiesFromRoom.add(new Door(x, y));


                case 'R' -> bodiesFromRoom.add(new CompanianCube(x, y));
                case 'K' -> bodiesFromRoom.add(new Button(x, y));
                case 'L' -> bodiesFromRoom.add(new Laser(x, y));


            }
        }
        return bodiesFromRoom;
    }
    public static  void roomchanges(int room, PhysicsWorld physicWorld) {


        switch (room) {
            case 1:
                for (Body body : Rooms.createRoom(Rooms.testRoom)) {
                    physicWorld.addBody(body);
                }

                break;
            case 2:
                for (Body body : Rooms.createRoom(Rooms.room1)) {
                    physicWorld.addBody(body);
                }


                break;

        }

    }
}
