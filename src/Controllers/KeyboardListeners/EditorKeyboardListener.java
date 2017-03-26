package Controllers.KeyboardListeners;

import Model.ModelFacade;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jordi on 3/26/2017.
 */
public class EditorKeyboardListener implements KeyListener {
    Set<Integer> pressedKeys= new HashSet<>();
    ModelFacade modelFacade;

    public EditorKeyboardListener(ModelFacade modelFacade) {
        this.modelFacade=modelFacade;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        unlockCamera();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        lockCamera();
    }

    public void unlockCamera(){
        if (pressedKeys.contains(KeyEvent.VK_CONTROL)){
            modelFacade.unlockCamera();
        }
    }
    public void lockCamera(){
        if (!pressedKeys.contains(KeyEvent.VK_CONTROL)) {
            modelFacade.lockCamera();
        }
    }
}
