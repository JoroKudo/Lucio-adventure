import javafx.scene.image.Image;
import org.dyn4j.geometry.MassType;

public class Mario extends GameObject {

    public Mario(double x, double y) {
        super(Images.MARIO, x, y);


        setUserData("Mario");

        setMass(MassType.NORMAL);
    }
}
