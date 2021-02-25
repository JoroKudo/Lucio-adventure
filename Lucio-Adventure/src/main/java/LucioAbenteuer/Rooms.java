package LucioAbenteuer;
import org.dyn4j.dynamics.Body;
import LucioAbenteuer.GameObjects.*;
import org.dyn4j.world.World;
import java.util.ArrayList;
import java.util.List;

public class Rooms {
    public static ExitLight exitlight;
    public static int room =1;
    public static BigLaser  bl;
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
            "0000000000000L0000000000000000" +
                    "0000000000000L0000000000000000" +
                    "0000000000000L0000000000000000" +
                    "0000K00000000L0000000000000000" +
                    "0000000000000L0R0000000000D000" +
                    "00K0000000000L0000000000BBBBBB" +
                    "0CBBB0000C000LBBBBB00000000000" +
                    "0000000000000L00000BB000000000" +
                    "00000000000B0L0C0C0C0C0C000000" +
                    "0000000BBBBB0L0000000000000000" +
                    "00000P0000000L000000000000000C" +
                    "0000BBB000000BBBBBBBBBBBB00000" +
                    "000000000000000000000000000000" +
                    "W00000000000K0000HHH000000000W" +
                    "W0000000000000000000000000000W" +
                    "00F00000000000FF000000000000F0";

    public static String room3 =
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW" +
                    "W0000000000B00000000000000000W" +
                    "W0000000000B00000000000000000W" +
                    "W0000R00000B00000B0000000000CW" +
                    "W000BB00000B00D0KB000BBB0000BW" +
                    "W0000000000BBBBBBB00000000000W" +
                    "WB0000000000000000000000R0000W" +
                    "W0000000I000000000000000BBB00W" +
                    "W000B00BBB00000000V0000000000W" +
                    "W000000000000000000BB00000000W" +
                    "WB000000000000000000000000000W" +
                    "W0000000000000000000000000000W" +
                    "W00B00000000000000000C0000000W" +
                    "W0000B0B0BB0000B0B000B0000000W" +
                    "WSSSSBBBSSSSSSSSSS0SSSSSSB0P0W" +
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
                    "W0000000000000000B00000000000W" +
                    "W0000000000000D00B00000000000W" +
                    "W0000C00000BBBBBBBBBBBB000000W" +
                    "WC000B00000000000000000000000W" +
                    "WB000000000000000000000000000W" +
                    "W00000C00000C0C0C0C00000R0000W" +
                    "WSSBBBBBSBBSBBBBBB0SSSSBBBB00W" +
                    "WBBBBBBBBBBB000000BBBBB000000W" +
                    "W0000000000000000000000000000W" +
                    "W00C0000000000R00000000000000W" +
                    "W00BB000000BBBB000000000000BBW" +
                    "W000000000000000000BBBBB00000W" +
                    "W00000000000000000000000SSS00W" +
                    "BBBBBBBBBBBBBBSSSSS0BBBBBBBBBW";

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
                case 'I' -> bodiesFromRoom.add(new LaserButton(x, y));
                case 'V' -> {bl =new BigLaser(x, y);bodiesFromRoom.add(bl);}
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
