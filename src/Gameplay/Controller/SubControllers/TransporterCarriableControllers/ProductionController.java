package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.MainController;
import Gameplay.Controller.MainViewController;
import Gameplay.Views.MainView.MainView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by jordi on 4/17/2017.
 */
public class ProductionController implements KeyListener, MainViewController {
    UserRequestController userRequestController = new UserRequestController();

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("doo something");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P){
            System.out.println("produceeeeeeeeeeeeeeeeeee!!!!!!!!!1");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("hello");
    }

    @Override
    public void deactivateController() {

    }

    @Override
    public void activateController(MainView mainView) {
        userRequestController.activateController(mainView);

        mainView.setFocusable(true);
        mainView.requestFocus();
        mainView.addKeyListener(this);

    }
}
