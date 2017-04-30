package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Controller.PanelControllers.WallSelectionController;
import Gameplay.Model.BuildAbilities.BuildAbility;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Views.MainView.MainView;
import MapBuilder.Model.Utility.HexaIndex;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * Created by jordi on 4/17/2017.
 */
public class BuildingController implements KeyListener, MainViewController {
    UserRequestController userRequestController = new UserRequestController();
    MainView mainView;
    boolean isPSVOn = false;
    boolean isWSVOn = false;
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_B && mainView != null) {
            isPSVOn = !isPSVOn;
            if (userRequestController.getRegion() != null) {
                List<BuildAbility> abilities = gameModelFacade.getBuildAbilities(userRequestController.getRegion());
                mainView.getProducerSelectionView().updateProducerImages(abilities);
            }
            mainView.getProducerSelectionView().setVisible(isPSVOn);

        }
        if (e.getKeyCode() == KeyEvent.VK_W && mainView != null) {
            isWSVOn = !isWSVOn;
            WallSelectionController wsc = new WallSelectionController(this);
            wsc.activateController(mainView);
            mainView.getWallSelectionView().setVisible(isWSVOn);
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
        this.mainView = mainView;
        userRequestController.activateController(mainView);
        mainView.getInputSelectionView().setVisible(true);
        mainView.getDisplay().setFocusable(true);
        mainView.getDisplay().requestFocus();
        mainView.getDisplay().addKeyListener(this);
    }

    public void buildWall(HexaIndex hexaIndex){
        System.out.println(userRequestController.getRegion());
        if (userRequestController.getRegion() != null) {
            gameModelFacade.buildWall(userRequestController.getRegion(), hexaIndex);
        }
    }
}
