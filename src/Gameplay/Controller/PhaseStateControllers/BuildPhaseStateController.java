package Gameplay.Controller.PhaseStateControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Controller.PhaseStateController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.BuildingController;
import Gameplay.Views.MainView.MainView;

import java.util.List;

/**
 * Created by jordi on 4/14/2017.
 */
public class BuildPhaseStateController extends PhaseStateController {
    BuildingController buildController;

    @Override
    public String toString() {
        return "BuildPhase";
    }

    @Override
    public void activateState(MainView mainView) {
        buildController = new BuildingController();
        buildController.activateController(mainView);
    }
}
