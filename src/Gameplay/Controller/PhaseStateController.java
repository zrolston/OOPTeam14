package Gameplay.Controller;

import Gameplay.Model.Utility.Actions.Action;
import Gameplay.Views.MainView.MainView;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

/**
 * Created by jordi on 4/13/2017.
 */
public abstract class ControllerState {
    private MainController mainController;
    private HashMap<MouseActions, Action> mouseActions = new HashMap<>();
    private HashMap<Character, Action> keyboardActions = new HashMap<>();
    ControllerState previous;

    public ControllerState(MainController mainController) {
        this.mainController = mainController;
    }

    public void addAction(MouseActions mouseAction, Action action) {
        mouseActions.put(mouseAction, action);
    }

    public void addAction(char character, Action action) {
        keyboardActions.put(character, action);
    }


    public abstract void activateController(MainView mainView);


    protected HashMap<Character, Action> getKeyboardActions() {
        return keyboardActions;
    }

    protected HashMap<MouseActions, Action> getMouseActions() {
        return mouseActions;
    }
}
