package Gameplay.Controller.PhaseStateControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Controller.PhaseStateController;
import Gameplay.Views.MainView.MainView;

import java.util.List;

/**
 * Created by jordi on 4/14/2017.
 */
public class TradePhaseStateController extends PhaseStateController {


    @Override
    protected List<MainViewController> getControllers() {
        return null;
    }

    @Override
    public String toString() {
        return "TradePhase";
    }

}
