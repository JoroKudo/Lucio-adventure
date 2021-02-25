package LucioAbenteuer;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Score {
    public int coinCounter = 0;
    public void draw(GraphicsContext gc) {
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFont(new Font("consolas", 25));
        gc.setFill(Color.YELLOW);
        gc.fillText(
                "COINS: " + coinCounter,
                Math.round(Const.CANVAS_WIDTH / 4),
                Math.round(60)
        );
    }
}

