package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.MainController;
import Gameplay.Controller.MainViewController;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.MainView.MainView;
import MapBuilder.Model.ModelFacade;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by jordi on 4/17/2017.
 */
public class ProductionController implements KeyListener, MainViewController {
    UserRequestController userRequestController = new UserRequestController();
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P && userRequestController.getRegion() != null){
            gameModelFacade.produce(userRequestController.getRegion());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void deactivateController() {

    }

    @Override
    public void activateController(MainView mainView) {
        userRequestController.activateController(mainView);
        mainView.getInputSelectionView().setVisible(true);
        mainView.getDisplay().setFocusable(true);
        mainView.getDisplay().requestFocus();
        mainView.getDisplay().addKeyListener(this);
    }
}
