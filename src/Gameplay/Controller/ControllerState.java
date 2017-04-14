package Gameplay.Controller;

import Gameplay.Model.Utility.Actions.Action;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

/**
 * Created by jordi on 4/13/2017.
 */
public abstract class ControllerState implements KeyListener, MouseListener {
    private MainController mainController;
    private HashMap<MouseActions, Action> mouseActions = new HashMap<>();
    private HashMap<Character, Action> keyboardActions = new HashMap<>();
    ControllerState previous;


    public void addAction(MouseActions mouseAction, Action action) {
        mouseActions.put(mouseAction, action);
    }

    public void addAction(char character, Action action) {
        keyboardActions.put(character,action);
    }

    abstract protected void rightClicked();

    abstract protected void leftClicked();


    public ControllerState(MainController mainController) {
        this.mainController = mainController;
    }

    public void changeState() {
        emptyActions();
        mainController.advanceToPreviousState();
    }

    private void emptyActions(){
        mouseActions.clear();
        keyboardActions.clear();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isRightClick(e)) {
            rightClicked();
            return;
        }

        if (isLeftClick(e)) {
            leftClicked();
        }

    }

    private boolean isRightClick(MouseEvent e) {
        return SwingUtilities.isRightMouseButton(e) && mouseActions.containsKey(MouseActions.RIGHT_CLICK);
    }

    private boolean isLeftClick(MouseEvent e) {
        return SwingUtilities.isLeftMouseButton(e) && mouseActions.containsKey(MouseActions.LEFT_CLICK);
    }


    protected HashMap<Character, Action> getKeyboardActions() {
        return keyboardActions;
    }

    protected HashMap<MouseActions, Action> getMouseActions() {
        return mouseActions;
    }
}
