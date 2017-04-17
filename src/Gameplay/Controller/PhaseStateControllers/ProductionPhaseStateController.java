package Gameplay.Controller.PhaseStateControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Controller.PhaseStateController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.ProductionController;
import Gameplay.Views.MainView.MainView;

import java.util.List;

/**
 * Created by jordi on 4/14/2017.
 */
public class ProductionPhaseStateController extends PhaseStateController {
    ProductionController productionController;

    @Override
    public String toString() {
        return "ProductionPhase";
    }

    @Override
    public void activateState(MainView mainView) {
        productionController = new ProductionController();
        productionController.activateController(mainView);
    }
}
