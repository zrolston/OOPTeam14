package Gameplay.Controller;

import Gameplay.Model.Utility.Actions.Action;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by jordi on 4/13/2017.
 */
public abstract class ControllerState implements KeyListener, MouseListener {
    MainController mainController;

    public ControllerState(MainController mainController){
        this.mainController=mainController;
    }

    public void changeState(ControllerState controllerState){

    }

    abstract public void addAction();
    abstract public void addAction(char character, Action action);
}
