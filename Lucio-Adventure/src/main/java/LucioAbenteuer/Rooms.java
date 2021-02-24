package LucioAbenteuer;

import org.dyn4j.dynamics.Body;
import LucioAbenteuer.GameObjects.*;
import org.dyn4j.world.World;

import java.util.ArrayList;
import java.util.List;

public class Rooms {
    public static ExitLight exitlight;
    public static int room =2;


    public static String room1 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "WC0000C0000000D00000000000000W" +
                    "W0000000000BBBBBBB00000000000W" +
                    "W0000000000000000000000C0C0C0W" +
                    "W000000000000000000000BB00BBBW" +
                    "W000BBBBBBB000000000000SSSS00W" +
                    "W0000000000000000000000BBBB00W" +
                    "W0000000000000000000000000000W" +
                    "W000000000R000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0P00000000000000000000000000W" +
                    "WBBB0000000000000FF0000000000W";


    public static String room2 =
            "0000000000000L0000000000000000" +
                    "0000000000000L0000000000000000" +
                    "0000000000000L0000000000000000" +
                    "0000K00000000L0000000000000000" +
                    "0000000000000L0R0000000000D000" +
                    "00K0000000000L0000000000BBBBBB" +
                    "0CBBB0000C000LBBBBB00000000000" +
                    "0000000000000LBBBBBBB000000000" +
                    "00000000000B0L0C0C0C0C0C000000" +
                    "0000000BBBBB0L0000000000000000" +
                    "00000P0000000L000000000000000C" +
                    "0000BBB000000BBBBBBBBBBBB00000" +
                    "000000000000000000000000000000" +
                    "W0000000000000000HHH000000000W" +
                    "W0000000000000000000000000000W" +
                    "00F00000000000FF000000000000F0";


    public static String room3 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "WC0000C0000000D0K000000000000W" +
                    "W0000000000BBBBBBB00000000000W" +
                    "W00000000000C0C0C0C0000C00000W" +
                    "WBB0BBBB000000000000000000000W" +
                    "W0000000000000000000000SSSS00W" +
                    "W00000000000BBBBBBB0000BBBB00W" +
                    "W0000000000000000000000000000W" +
                    "W000000000R000000000000000000W" +
                    "W0000000000000000HHH000000000W" +
                    "W0P00000000000000000000000000W" +
                    "000000000000000000000000000000";

    public static String room4 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W000000D000000000000000000000W" +
                    "WC00BBBBBBB000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W00000000000C0C0C0C0000C00000W" +
                    "WBB0BBBB000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W00000000000R0000000000000000W" +
                    "W000000000000000000000000R000W" +
                    "W00000000BBBB0000000B000BBBBBW" +
                    "W00000000BBBB0000000B000BBBBBW" +
                    "WSSSSSSSSBBBBSSSSSSSB0P0BBBBBW" +
                    "WBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";

    public static String room5 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "WC0000C0000000D00000000000000W" +
                    "W0000000000BBBBBBB00000000000W" +
                    "W00000000000C0C0C0C0000C00000W" +
                    "WBB0BBBB000000000000000000000W" +
                    "W0000000000000000000000SSSS00W" +
                    "W00000000000BBBBBBB0000BBBB00W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W000000000000000000000000S000W" +
                    "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";


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
                case 'S' -> bodiesFromRoom.add(new Spikes(x, y));
                case 'C' -> bodiesFromRoom.add(new Coin(x, y));
                case 'F' -> bodiesFromRoom.add(new Floor(x, y));
                case 'H' -> bodiesFromRoom.add(new Heart(x, y));
                case 'R' -> bodiesFromRoom.add(new CompanionCube(x, y));
                case 'P' -> bodiesFromRoom.add(new Button(x, y));
                case 'L' -> bodiesFromRoom.add(new Laser(x, y));
                case 'K' -> bodiesFromRoom.add(new Key(x, y));
                case 'D' -> {
                    bodiesFromRoom.add(new Door(x, y));
                    exitlight = new ExitLight((x - 0.4) * Const.BLOCK_SIZE, (y - 2) * Const.BLOCK_SIZE);
                }
            }
        }
        return bodiesFromRoom;
    }

    public static void roomchanges(int room, World<Body> physicWorld) {


        switch (room) {
            case 1:
                for (Body body : Rooms.createRoom(room1)) {
                    Images.bgp = Images.LVL1;

                    physicWorld.addBody(body);
                }

                break;
            case 2:
                for (Body body : createRoom(room2)) {
                    physicWorld.addBody(body);
                    Images.bgp = Images.LVL2;
                }
                break;
            case 3:
                for (Body body : createRoom(room3)) {
                    physicWorld.addBody(body);
                    Images.bgp = Images.LVL3;

                }
                break;
            case 4:
                for (Body body : createRoom(room4)) {
                    physicWorld.addBody(body);
                    Images.bgp = Images.LVL4;
                }
                break;
            case 5:
                for (Body body : createRoom(room5)) {
                    physicWorld.addBody(body);
                }
                break;


        }

    }
}
