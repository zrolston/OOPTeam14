package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.DropRegionController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.MoveRegionController;
import Gameplay.Model.Iterators.CarriableIterator;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.MainView.MainView;

/**
 * Created by jordi on 4/16/2017.
 */
public class DropController extends TransporterCarriableController {

    private DropRegionController dropRegionController = new DropRegionController(this);
    private MoveRegionController moveRegionController = new MoveRegionController(this);

    public DropController() {
        changeToDefaultController();
        hidePanel();
    }

    @Override
    protected void carriableClick() {
        //Todo:get the good and pass it to drop region controller
        //TODO: view check if the region is a river, if it isn't drop it on the tile

        activateDropRegionController();
        hidePanel();
    }

    @Override
    protected void resume() {
        changeToDefaultController();
        clearCurrentCarriable();

    }

    @Override
    protected void transporterClick() {
        moveRegionController.allowMovement();
    }

    public void changeToDefaultController() {
        checkForDisplay();
        moveRegionController.activateController(getMainView());
    }

    public void checkForDisplay() {
        if (getTransporterIterator().size() == 0) {
            hidePanel();
            return;
        }
        showPanel();
    }

    public void dropGood(){
        removeCarriable();
    }

    private void activateDropRegionController(){
        dropRegionController.activateController(getMainView());
        dropRegionController.receiveCarriable(getCurrentCarriable());
        dropRegionController.receiveTransporter(getCurrentTransporter());
    }
}

