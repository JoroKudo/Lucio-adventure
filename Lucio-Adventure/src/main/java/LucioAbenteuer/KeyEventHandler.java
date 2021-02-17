package LucioAbenteuer;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyEventHandler implements EventHandler<KeyEvent> {

    private boolean isLeftKeyPressed = false;
    private boolean isRightKeyPressed = false;
    private boolean isSpaceKeyPressed = false;

    private boolean isLeftKeyReleased = true;
    private boolean isRightKeyReleased = true;
    private boolean isSpaceKeyReleased = true;

    @Override
    public void handle(KeyEvent event) {
        boolean pressed = event.getEventType() == KeyEvent.KEY_PRESSED;
        switch (event.getCode()) {
            case A:
                isLeftKeyPressed = pressed;
                break;
            case D:
                isRightKeyPressed = pressed;
                break;
            case SPACE:
                isSpaceKeyPressed = pressed;
                break;
        }
        boolean released = event.getEventType() == KeyEvent.KEY_RELEASED;
        switch (event.getCode()) {
            case A:
                isLeftKeyReleased = released;
                break;
            case D:
                isRightKeyReleased = released;
                break;
            case SPACE:
                isSpaceKeyReleased = released;
                break;
        }
    }

    public boolean isLeftKeyPressed() {
        return isLeftKeyPressed;
    }

    public boolean isRightKeyPressed() {
        return isRightKeyPressed;
    }

    public boolean isSpaceKeyPressed() {
        return isSpaceKeyPressed;
    }

    public boolean isLeftKeyReleased() {
        return isLeftKeyReleased;
    }

    public boolean isRightKeyReleased() {
        return isRightKeyReleased;
    }

    public boolean isSpaceKeyReleased() {
        return isSpaceKeyReleased;
    }
}
