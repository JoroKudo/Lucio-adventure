import org.dyn4j.dynamics.Body;

import java.util.ArrayList;
import java.util.List;

public class Rooms {

    private static String room1 =
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

    public static List<Body> createRoom1() {
        final int ROW_LENGHT = Const.CANVAS_WIDTH / Const.BLOCK_SIZE;
        ArrayList<Body> bodiesFromRoom = new ArrayList<>();
        for (int i = 1; i < room1.length() -1; i++) {
            char symb = room1.charAt(i);
            double y = (int)(i / ROW_LENGHT);
            double x = i % ROW_LENGHT;
            if (symb == 'B'){
                bodiesFromRoom.add(new Block(x, y));
            }
            if (symb == 'C'){
                bodiesFromRoom.add(new Coin(x,y));
            }
            if (symb == 'F'){
                bodiesFromRoom.add(new Floor(x,y));
            }
            if (symb == 'D') {
                bodiesFromRoom.add(new Door(x, y));
            }
        }
        return bodiesFromRoom;
    }
}
