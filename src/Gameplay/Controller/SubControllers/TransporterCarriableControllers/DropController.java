package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.PhaseStateControllers.MovementStateControllers.MovementState;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.DropRegionController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.MoveRegionController;
import Gameplay.Views.MainView.MainView;

/**
 * Created by jordi on 4/16/2017.
 */
public class DropController extends TransporterCarriableController implements MovementState {

    private DropRegionController dropRegionController = new DropRegionController(this);
    private MoveRegionController moveRegionController = new MoveRegionController(this);

    //iterator of goods
    //iterator of transporters

    public DropController() {
        changeToDefaultController();
        hidePanel();
    }

    @Override
    protected void carriableClick() {
        //Todo:get the good and pass it to drop region controller
        //TODO: view check if the region is a river, if it isn't drop it on the tile
        dropRegionController.activateController(getMainView());
        dropRegionController.receiveCarriable(getCurrentCarriable());
        hidePanel();
    }

    @Override
    protected void resume() {
        changeToDefaultController();
        clearCurrentCarriable();

    }

    @Override
    protected void transporterClick() {
        //todo: get goods associated with the transporter
        //TODO: addRightColumn();
        moveRegionController.allowMovement();
    }

    @Override
    public void advance() {
        dropRegionController.receiveCarriable(getCurrentCarriable());
    }

    @Override
    public void update(MainView mainView) {
        activateController(mainView);
    }

    public void changeToDefaultController() {
        checkForDisplay();
        moveRegionController.activateController(getMainView());
    }

    public void checkForDisplay() {
        //TODO: if Trasnporter iterator is not empty
        //TODO: set view visible
        //TODO: if transporter iterator is empty
        //TODO: set view invisible
    }


}

