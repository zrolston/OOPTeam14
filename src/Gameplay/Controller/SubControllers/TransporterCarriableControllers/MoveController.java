package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.SubControllers.RegionCarriableControllers.PickUpController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.DropRegionController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.MoveRegionController;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.GameModelFacade;

/**
 * Created by jordi on 4/16/2017.
 */
public class MoveController extends TransporterCarriableController {

    private DropRegionController dropRegionController = new DropRegionController(this);
    private MoveRegionController moveRegionController = new MoveRegionController(this);
    private PickUpController pickUpController = new PickUpController(this);
    Region selectedRegion;
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();

    public MoveController() {
        changeToDefaultController();
        hidePanel();
    }

    @Override
    protected void carriableClick() {
        //TODO: view check if the region is a river, if it isn't drop it on the tile and gameModelFacade.canDropCarriable()
        activateDropRegionController();
        hidePanel();
    }

    @Override
    protected void transporterClick() {
        moveRegionController.allowMovement();
        moveRegionController.receiveTransporter(getCurrentTransporter());
        pickUpController.receiveTransporter(getCurrentTransporter());
    }

    @Override
    protected void resume() {
        changeToDefaultController();
        clearCurrentCarriable();

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

    public void dropCarriable(Region region){
        gameModelFacade.dropCarriable(region, getCurrentTransporter(),getCurrentCarriable());
        removeCarriable();

    }
    public Region getPickUpRegion(){
        return selectedRegion;
    }
    public void setRegion(Region region){
        selectedRegion = region;
        pickUpController.receiveRegion(region);
    }

    private void activateDropRegionController(){
        dropRegionController.activateController(getMainView());
        dropRegionController.receiveCarriable(getCurrentCarriable());
        dropRegionController.receiveTransporter(getCurrentTransporter());
    }

}

