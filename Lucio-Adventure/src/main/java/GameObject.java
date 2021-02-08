import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.AABB;
import org.dyn4j.geometry.Polygon;
import org.dyn4j.geometry.Rectangle;
import org.dyn4j.geometry.Vector2;

public abstract class GameObject extends Body {

    private final Image image;

    public GameObject(Image image, double x, double y)  {
        this.image = image;
        this.translate(x, y);

        addFixture(new Rectangle(image.getWidth() / Const.SCALE, image.getHeight() / Const.SCALE));
    }

    public void draw(GraphicsContext gc) {

        Affine originTrans = gc.getTransform();
        Affine transfrom = new Affine();
        transfrom.appendTranslation(this.transform.getTranslationX() * Const.SCALE, this.transform.getTranslationY() * Const.SCALE);
        transfrom.appendRotation(this.transform.getRotation().toDegrees());
        transfrom.appendTranslation(1, -1);

        gc.transform(transfrom);

        Polygon rect = (Polygon) this.getFixture(0).getShape();
        double x = rect.getVertices()[0].x;
        double y = rect.getVertices()[0].y;

        // We need the top left corner of our hitbox.
        //AABB aabb = this.getFixture(0).getShape().createAABB();
        //double x = getWorldCenter().x + aabb.getMinX();
        //double y = getWorldCenter().y + aabb.getMinY();
        gc.drawImage(image, x * Const.SCALE , y * Const.SCALE); // Für Java FX zu Dyn4J muss die Y-Achse gespiegelt werden

        gc.setTransform(originTrans);

    }
}


        /*AffineTransform ot = g.getTransform();
        AffineTransform lt = new AffineTransform();
        lt.translate(this.transform.getTranslationX() * Window.SCALE, this.transform.getTranslationY() * Window.SCALE);
        lt.rotate(this.transform.getRotation());
        gc.transform(lt);
        for (BodyFixture fixture : this.fixtures) {
            this.draw(g, (Polygon) fixture.getShape(), Window.SCALE);
        }
        g.setTransform(ot);*/