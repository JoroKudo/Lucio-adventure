import org.dyn4j.dynamics.Body;

import java.util.ArrayList;
import java.util.List;

public class Rooms {

    public static String room1 =
            "000000000000000000000000000000" +

                    "000000000000000000000000000000" +
                    "000000000000000000000000000000" +
                    "000000000000000000000000000000" +

                    "000000000000000000000000000000" +
                    "000000000000000000000000000000" +
                    "0C0000000C0000000D000000000000" +
                    "00000000000000BBBBBBB000000000" +
                    "000000000000000C0C0C0C0C000000" +
                    "BBB0000BBBB0000000000000000000" +
                    "00000000000000000000000000000C" +
                    "00000000000000BBBBBBBBBBB00000" +
                    "000000000000000000000000000000" +
                    "0000000000000000000000000000BB" +
                    "000000000000000000000000000000" +
                    "00000000000000FF00000000000000";

    public static String testRoom =
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" +


                    "B0000000000000000000000000000B" +
                    "000000000000000000000000000000" +
                    "000000000000000000000000000000" +

                    "B0000000000000000000000000000B" +
                    "B0000000000000000000000000000B" +
                    "BC0000000C0000000D00000000000B" +
                    "B0000000000000BBBBBBB00000000B" +
                    "B00000000000000C0C0C0C0C00000B" +
                    "BBB0000BBBB000000000000000000B" +
                    "B0000000000000000000000000000B" +
                    "B0000000000000000000000000000B" +
                    "B0000000000000000000000000000B" +
                    "BCCCCCCCCCC000CCCCCCCCC0R0CCCC" +
                    "B0000000000000000000000000000B" +
                    "B000FF000000000000000000FF000B";


    public static List<Body> createRoom(String roomname) {
        final double ROW_LENGHT = 30;
        ArrayList<Body> bodiesFromRoom = new ArrayList<>();
        for (int i = 1; i < roomname.length() - 1; i++) {
            char symb = roomname.charAt(i);
            double y = (int) (i / ROW_LENGHT);
            double x = i % ROW_LENGHT;
            switch (symb) {
                case 'B' -> bodiesFromRoom.add(new Block(x, y));


                case 'C' -> bodiesFromRoom.add(new Coin(x, y));


                case 'F' -> bodiesFromRoom.add(new Floor(x, y));


                case 'D' -> bodiesFromRoom.add(new Door(x, y));

                case 'R' -> bodiesFromRoom.add(new CompanianCube(x, y));


            }
        }
        return bodiesFromRoom;
    }
}
