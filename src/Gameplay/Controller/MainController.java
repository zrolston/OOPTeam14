package Gameplay.Controller;


import Gameplay.Views.MainView.MainView;

import java.util.Stack;

/**
 * Created by jordi on 4/13/2017.
 */
public class MainController {
    private Stack<PhaseStateController> stateManager = new Stack<>();
    private MainView view;
    PhaseStateController currentState;


    public MainController(MainView view) {
        this.view = view;
    }

    public void setState(PhaseStateController controller) {
        currentState = controller;
    }

    private void addToView() {
        //        TODO add the state to the view = stateManager.peek()
    }


}
