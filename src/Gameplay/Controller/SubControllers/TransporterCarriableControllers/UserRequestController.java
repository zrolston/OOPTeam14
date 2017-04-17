package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.SubControllers.RegionCarriableControllers.CarriableDropUserRequest;
import Gameplay.Controller.SubControllers.RegionCarriableControllers.PickUpController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.DropRegionController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.MoveRegionController;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.Utility.CursorState;

/**
 * Created by jordi on 4/17/2017.
 */


/**
 * Created by jordi on 4/16/2017.
 */
public class UserRequestController extends MoveController implements DropController{

    GameModelFacade gameModelFacade = GameModelFacade.getInstance();

    public UserRequestController() {
        assignPickUpController(new CarriableDropUserRequest (this));
    }

    @Override
    protected void transporterClick() {
        sendCarriable();
        sendTransporter();
    }
    @Override
    public void changeToDefaultController() {
        checkForDisplay();
        getMoveRegionController().activateController(getMainView());
    }

    @Override
    public void dropCarriable(Region region){
        //TODO: maybe add a check
        gameModelFacade.addCarriableToUserRequest(getCurrentTransporter(),getCurrentCarriable());
        //TODO: add to the bottom panel
        removeCarriable();
        TransporterIterator trans = gameModelFacade.getTransporters(region);
        addTransporters(trans);
    }

    @Override
    public void setRegion(Region region){
        selectedRegion = region;
        gameModelFacade.resetUserRequest();
        getPickupController().activateController(getMainView());
        getPickupController().receiveRegion(region);
    }

    @Override
    protected void carriableClick() {
        //TODO: view check if the region is a river, if it isn't drop it on the tile and gameModelFacade.canDropCarriable()
        dropCarriable(getCurrentTransporter().getCurrentRegion());
        //TODO: UNCOMENT THIISSSSSSS!!!!!!!!!!!!!!!!!!!!!!
//        checkForDisplay();
    }


}

