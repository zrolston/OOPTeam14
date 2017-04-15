package Gameplay.Controller;

import Gameplay.Model.Utility.Actions.Action;
import Gameplay.Views.MainView.MainView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jordi on 4/13/2017.
 */
public abstract class PhaseStateController  {

    List<MainViewController> controllers = new ArrayList<>();

    private HashMap<MouseActions, Action> mouseActions = new HashMap<>();
    private HashMap<Character, Action> keyboardActions = new HashMap<>();


    public void addAction(MouseActions mouseAction, Action action) {
        mouseActions.put(mouseAction, action);
    }

    public void addAction(char character, Action action) {
        keyboardActions.put(character, action);
    }

    protected abstract List<MainViewController> getControllers();

    protected void setControllers() {
        controllers.addAll(getControllers());
    }

    public void activateController(MainView mainView) {
        for (MainViewController mvc : controllers) {
            mvc.activateController(mainView);
        }
    }

    protected HashMap<Character, Action> getKeyboardActions() {
        return keyboardActions;
    }

    protected HashMap<MouseActions, Action> getMouseActions() {
        return mouseActions;
    }
}
