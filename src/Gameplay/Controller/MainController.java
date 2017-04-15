package Gameplay.Controller;


import Gameplay.Views.MainView.MainView;

import java.util.Stack;

/**
 * Created by jordi on 4/13/2017.
 */
public class MainController {
    private Stack<PhaseStateController> stateManager = new Stack<>();
    private MainView mainView;
    PhaseStateController currentState;


    public MainController(MainView view) {
        this.mainView = view;
    }

    public void setState(PhaseStateController controller) {
        currentState = controller;
        currentState.activateController(mainView);
    }


}
