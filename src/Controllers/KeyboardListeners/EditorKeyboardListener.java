package Controllers.KeyboardListeners;

import Model.ModelFacade;
import Model.Utility.HexLocation;
import Views.MapEditor.MapEditorView;
import Views.Utility.PixelMap;
import Views.Utility.PixelPoint;
import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jordi on 3/26/2017.
 */
public class EditorKeyboardListener implements KeyListener {

    Component component;
    Set<Integer> pressedKeys= new HashSet<>();
    ModelFacade modelFacade;
    MapEditorView view;

    public void setComponent(Component component) {
        this.component = component;
    }

    public EditorKeyboardListener(ModelFacade modelFacade, MapEditorView mapEditorView) {
        this.modelFacade=modelFacade;
        view=mapEditorView;
    }

    public EditorKeyboardListener(ModelFacade modelFacade) {
        this.modelFacade = modelFacade;
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
            if(component != null)component.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }
    public void lockCamera(){
        if (!pressedKeys.contains(KeyEvent.VK_CONTROL)) {
            modelFacade.lockCamera();
            if(component != null)component.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
}
