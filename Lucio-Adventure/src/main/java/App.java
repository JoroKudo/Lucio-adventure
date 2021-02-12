import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.BroadphaseCollisionData;
import org.dyn4j.world.World;
import org.dyn4j.dynamics.Body;
import org.dyn4j.world.listener.CollisionListenerAdapter;

//import static jdk.vm.ci.meta.JavaKind.Char;

public class App extends Application {

    private World<Body> physicWorld = new World<Body>();
    private GraphicsContext gc;
    private Lucio lucio;

    private String levelMap =
         "00000B00000B000B0000000" +
         "00BB0000L00000000000000" +
         "00000000000000000000000";

    public void createWorld(World<Body> physicWorld) {

        for (int i = 0; i < levelMap.length(); i++) {
            char symb = levelMap.charAt(i);
            if (symb == 'B'){
                double x = i;
                double y = Const.BLOCK_SIZE;
                physicWorld.addBody(new Block(x,y)); // i * Const.BLOCK_SIZE
            }
        }

    }


    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Canvas canvas = new Canvas(Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

//        lucio = new Lucio(0.8, 11, physicWorld);
//        Floor floor = new Floor(12.52, 13.42);
//        Largeblock largeblock = new Largeblock(24.3, 11.5);
//        Block row_of_blocks = new Block(19, 10);
//        Block row_of_blocks1 = new Block(14.8, 10);
//        Block row_of_blocks2 = new Block(10.6, 10);
//        Block row_of_blocks3 = new Block(6, 8);
//        Block row_of_blocks4 = new Block(14, 6);
//        Pair_Of_Blocks pair_of_blocks = new Pair_Of_Blocks(0.8, 8);
//        Coin coin = new Coin(24.6, 9);
//        Coin coin1 = new Coin(20, 7);
//        Coin coin2 = new Coin(18, 7);
//        Coin coin3 = new Coin(16, 7);
//        Coin coin4 = new Coin(14, 7);
//        Coin coin5 = new Coin(12, 7);



//        physicWorld.setGravity(new Vector2(0, 9.8));
//        physicWorld.addBody(lucio);
//        physicWorld.addBody(floor);
//        physicWorld.addBody(largeblock);
//        physicWorld.addBody(row_of_blocks);
//        physicWorld.addBody(row_of_blocks1);
//        physicWorld.addBody(row_of_blocks2);
//        physicWorld.addBody(row_of_blocks3);
//        physicWorld.addBody(pair_of_blocks);
//        physicWorld.addBody(row_of_blocks4);
//        physicWorld.addBody(coin);
//        physicWorld.addBody(coin1);
//        physicWorld.addBody(coin2);
//        physicWorld.addBody(coin3);
//        physicWorld.addBody(coin4);
//        physicWorld.addBody(coin5);



        physicWorld.addCollisionListener(new CollisionListenerAdapter<>() {

            @Override
            public boolean collision(BroadphaseCollisionData<Body, BodyFixture> collision) {
                Body body1 = collision.getBody1();
                Body body2 = collision.getBody2();

                if (body1 instanceof Lucio && body2 instanceof Coin) {
                    physicWorld.removeBody(body2);
                    return false;
                }
                if (body2 instanceof Lucio && body1 instanceof Coin) {
                    physicWorld.removeBody(body1);
                    return false;
                }


                return true;
            }

        });


        scene.setOnKeyPressed(e -> {

            if (lucio.isOnGround()) {

                if (e.getCode() == KeyCode.SPACE) {
                    lucio.jump();
                }

                if (e.getCode() == KeyCode.A) {
                    lucio.walkLeft();

                }

                if (e.getCode() == KeyCode.D) {
                    lucio.walkRight();
                }
            }

        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                lucio.setLinearVelocity(0, 0);
            }

            if (e.getCode() == KeyCode.RIGHT) {
                lucio.setLinearVelocity(0, 0);
                System.out.println(lucio.getLinearVelocity());
            }
        });

        FancyAnimationTimer animationTimer = new FancyAnimationTimer() {
            @Override
            protected void doHandle(double elapsedTime) {
                physicWorld.update(elapsedTime);
                gc.drawImage(Images.GAME_BACKGROUND, 0, 0);
                //gc.clearRect(0,0, Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);

                lucio.getTransform().setRotation(0);
                lucio.update();

                for (Body body : physicWorld.getBodies()){
                    GameObject gameObject = (GameObject) body;
                    gameObject.draw(gc);
                }

            }
        };

        animationTimer.start();
    }


}