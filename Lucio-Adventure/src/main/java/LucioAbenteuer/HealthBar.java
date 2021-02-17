package LucioAbenteuer;

import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Affine;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Polygon;
import org.dyn4j.geometry.Rectangle;

public class HealthBar {
    public int life=3;


    public Image image = Images.FULLHP;





    public void draw(GraphicsContext gc) {



            switch (life) {
                case 0:

                        System.out.println("ded");


                    break;
                case 1:

                        image = Images.LOWHP;



                    break;
                case 2:
                image = Images.MIDHP;
                    break;
                case 3:
                    image = Images.FULLHP;


                    break;

            }




        gc.drawImage(image, Const.CANVAS_WIDTH / 2 - 70, 25);

    }
}

