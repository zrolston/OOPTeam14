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

        if (getCurrentRegion()!= null && getCurrentCarriable()!= null) {
            //TODO: add to the bottom panel
            gmf.addCarriableToUserRequest(getCurrentRegion(), getCurrentCarriable());
            removeCarriable();
        }
    }
}
