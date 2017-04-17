package Gameplay.Controller.SubControllers.RegionCarriableControllers;

import Gameplay.Controller.SubControllers.TransporterCarriableControllers.MoveController;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;

/**
 * Created by jordi on 4/17/2017.
 */
public class CarriableDropUserRequest extends PickUpController{

    public CarriableDropUserRequest(MoveController moveController) {
        super(moveController);
    }

    protected void carriableClick() {
        GameModelFacade gmf = GameModelFacade.getInstance();

        Transporter currentTrans = MoveController.currentTrans;
        if (areContributorsNull( currentRegion, currentTrans, getCurrentCarriable())) {
            gmf.pickUpCarriable(currentRegion, currentTrans, getCurrentCarriable());
            removeCarriable();
        }
    }
}
