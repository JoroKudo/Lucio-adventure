package LucioAbenteuer;

import LucioAbenteuer.GameObjects.*;
import org.dyn4j.dynamics.Body;
import org.dyn4j.world.World;

import java.util.ArrayList;
import java.util.List;

public class Rooms {
    public static ExitLight exitlight;
    public static int room = 1;
    public static BigLaser bl;
    public static String room1 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "WC0000C0000000D00000000000000W" +
                    "W0000000000BBBBBBB00000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W000BBBBBBB000000000000C0C0C0W" +
                    "W0000000000000000000000BBBBB0W" +
                    "W0000000000000000000000000000W" +
                    "W000000000R00000000BB00000000W" +
                    "W0000000000000000000000000000W" +
                    "W0P000000000000BB000000000000W" +
                    "WBBB0000000000000FF0000000000W";

    public static String room2 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W000000000000L000000000000000W" +
                    "W000000000000L000000000000000W" +
                    "W000K00000000L000000000000000W" +
                    "W0BBB00000000L0R0000000000D00W" +
                    "W0BBB00000000L0000000000BBBBBW" +
                    "WCBBB0000C000LBBBBB0000000000W" +
                    "W000000000000L00000BB00000000W" +
                    "W0000000000B0L0C0C0C0C0C00000W" +
                    "W000000BBBBB0L000000000000000W" +
                    "W0000P0B00000L000000000000000W" +
                    "W000BBBB00000BBBBBBBBBBBB0000W" +
                    "W0000000000000000000000000000W" +
                    "W00000000000K0000HHH000000000W" +
                    "W0000000000000000000000000000W" +
                    "00F00000000000FF000000000000FW";

    public static String room3 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000B00000000000000000W" +
                    "W0000000000B00000000000000000W" +
                    "W00000R0000B0000000000R00000CW" +
                    "W0000BBB000B00D000000BBB0000BW" +
                    "WC00000B000BBBBBBB00000B00000W" +
                    "WB00000B000B00000000000B00000W" +
                    "W000000B0I0B00000000000BBBB00W" +
                    "W0000BBBBBBB000000V0H00000000W" +
                    "W000000000000000000BBB0000000W" +
                    "W0000000000000000000000000000W" +
                    "WBB00000000000000000000000000W" +
                    "WBB0000000C0000C0000000000000W" +
                    "WBB00BBB00B0000B00000B0000000W" +
                    "WBBQQBBBQQBQQQQBSS0SSBQQQB0P0W" +
                    "WBBBBBBBBBBBBBBBBBBBBBBBBBBBBW";

    public static String room4 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W000000D000000000000000000000W" +
                    "WC00BBBBBBB000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "WBB0BBBB0000C0C0C0C0000C00000W" +
                    "W0000000000000000000000000000W" +
                    "W00000000R0000000000000000000W" +
                    "W000000000000000000000000R000W" +
                    "W00000BBBBB000000000B000BBBBBW" +
                    "W00000BBBBB000000000B000BBBBBW" +
                    "WSSSSSBBBBBSSSSSSSSSB0P0BBBBBW" +
                    "WBBBBBBBBBBBBBBBBBBBBBBBBBBBBW";

    public static String room5 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000000000B00000000000W" +
                    "W0000000000000000B0K000000000W" +
                    "W00000C0000000D00B0H000000000W" +
                    "W00000B0000BBBBBBBBBB00000000W" +
                    "WC000000000000000000000000000W" +
                    "WB000000000000C00000000000000W" +
                    "W00000C00000C0H0C0000000R0000W" +
                    "WQQQBBBBQQQBBBBBBBS00SBBBB000W" +
                    "W0000000000000000BBBBBB000000W" +
                    "W0000000000000000000000000000W" +
                    "W00C0000000000R00000000000000W" +
                    "W00BB000000BBBB000000000000BBW" +
                    "W000000000BBBB00000BBBBB000BBW" +
                    "W00000000BBBBB00000BBBBBQQQBBW" +
                    "BBBBBBBBBBBBBBSSSSSBBBBB000BBW";


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
                case 'L' -> bodiesFromRoom.add(new Laser(x, y, Images.LASER_BEAM));
                case 'Q' -> bodiesFromRoom.add(new Laser(x, y, Images.RED_LASER));
                case 'K' -> bodiesFromRoom.add(new Key(x, y));
                case 'I' -> bodiesFromRoom.add(new LaserButton(x, y));
                case 'V' -> {
                    bl = new BigLaser(x, y);
                    bodiesFromRoom.add(bl);
                }
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
