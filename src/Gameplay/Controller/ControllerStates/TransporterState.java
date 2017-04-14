package Gameplay.Controller.ControllerStates;

import Gameplay.Controller.ControllerState;
import Gameplay.Controller.MainController;
import Gameplay.Controller.MouseActions;
import Gameplay.Model.Utility.Actions.Action;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by jordi on 4/13/2017.
 */
public class TransporterState extends ControllerState {

    @Override
    protected void rightClicked() {
        Action action = getKeyboardActions().get(MouseActions.RIGHT_CLICK);
        action.execute();
        changeState();
    }

    @Override
    protected void leftClicked() {
        Action action = getKeyboardActions().get(MouseActions.LEFT_CLICK);
        action.execute();
        changeState();
    }

    public TransporterState(MainController mainController) {
        super(mainController);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }



    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
