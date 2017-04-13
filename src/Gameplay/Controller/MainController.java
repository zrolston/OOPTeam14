package Gameplay.Controller;

/**
 * Created by jordi on 4/13/2017.
 */
public class MainController {
    private ControllerState currentState;

    public void setState(ControllerState controllerState){
        currentState=controllerState;
    }
}
