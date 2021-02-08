import javafx.scene.image.Image;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;

public class Mario extends GameObject {

    public Mario(double x, double y) {
        super(Images.MARIO, x, y);

        setMass(MassType.NORMAL);
    }

    public void jump(){
        applyForce(new Vector2(0, 10 * Const.SCALE));
    }
}
