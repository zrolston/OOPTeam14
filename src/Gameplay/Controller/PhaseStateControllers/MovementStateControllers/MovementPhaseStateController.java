package Gameplay.Controller.PhaseStateControllers.MovementStateControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Controller.PanelControllers.MapSelectionControllers.RegionSelectionController;
import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.PhaseStateController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.DropController;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Views.MainView.MainView;

import java.util.List;

/**
 * Created by jordi on 4/14/2017.
 */
public class MovementPhaseStateController extends PhaseStateController {
    DropController dropController = new DropController();


    @Override
    public void activateController(MainView mainView) {
        dropController.activateController(mainView);
    }

    @Override
    public String toString() {
        return "MovementPhase";
    }

}
