import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Affine;
import org.dyn4j.geometry.Polygon;
import org.dyn4j.geometry.Rectangle;

public class Score {
    protected Image image;
    public int coinCounter = 0;



    public void addCoinToCounter(int coinsadded) {
        this.coinCounter = this.coinCounter+coinsadded;
    }


    public void draw(GraphicsContext gc) {
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFont(new Font("consolas", 30));
        gc.fillText(
                "YOU HAVE COLLECTED " + coinCounter +" COINS SO FAR",
                Math.round(Const.CANVAS_WIDTH/2),
                Math.round(25)

        );

    }
}

