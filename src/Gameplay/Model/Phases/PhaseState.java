package Gameplay.Model.Phases;

import Gameplay.Controller.PhaseStateController;

public interface PhaseState {

    void start();
    void advance();
    PhaseStateController getPhaseController();

}
