package Gameplay.Controller.PhaseStateControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Controller.PhaseStateController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.TradingController;
import Gameplay.Views.MainView.MainView;

import java.util.List;

/**
 * Created by jordi on 4/14/2017.
 */
public class TradePhaseStateController extends PhaseStateController {

    TradingController tradingController;

    @Override
    public String toString() {
        return "TradePhase";
    }

    @Override
    public void activateState(MainView mainView) {
        tradingController= new TradingController();
        tradingController.activateController(mainView);
    }
}
