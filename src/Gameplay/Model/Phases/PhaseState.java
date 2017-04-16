package Gameplay.Model.Phases;

import Gameplay.Controller.PhaseStateController;

public interface PhaseState {

    void advance();
    PhaseStateController getPhaseController();

}
