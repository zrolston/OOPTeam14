package Gameplay.Controller.PhaseStateControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Controller.PhaseStateController;

import java.util.List;

/**
 * Created by jordi on 4/14/2017.
 */
public class WonderPhaseStateController extends PhaseStateController {
    @Override
    protected List<MainViewController> getControllers() {
        return null;
    }

    @Override
    public String toString() {
        return "WonderPhase";
    }
}
