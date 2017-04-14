package Gameplay.Controller;

import Gameplay.Controller.ControllerStates.NativeStates.NativeState;

import java.util.Stack;

/**
 * Created by jordi on 4/13/2017.
 */
public class MainController {
    private Stack<ControllerState> stateManager = new Stack<>();


    public void setNativeState(NativeState nativeState) {
        if (!stateManager.empty()) {
            stateManager.clear();
        }
        stateManager.add(nativeState);
        addToView();
    }

    /**
     * used to set the state from the phase manager
     *
     * @param controllerState
     */
    public void setState(ControllerState controllerState) {
        stateManager.add(controllerState);
    }

    /**
     * used to go to the previous state
     * checks if there are more than one states on the state manager
     */
    public void advanceToPreviousState() {
        if (stateManager.size() > 1) {
            stateManager.pop();
            addToView();
        }
    }

    private void addToView() {
        //        TODO add the state to the view = stateManager.peek()
    }


}
