package Gameplay.Controller.PhaseStateControllers;

import Gameplay.Controller.PhaseStateController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.MoveController;
import Gameplay.Views.MainView.MainView;

/**
 * Created by jordi on 4/14/2017.
 */
public class MovementPhaseStateController extends PhaseStateController {
    MoveController moveController;
    @Override
    public void activateController(MainView mainView) {
        moveController = new MoveController();
        moveController.activateController(mainView);
    }

    @Override
    public String toString() {
        return "MovementPhase";
    }

}
