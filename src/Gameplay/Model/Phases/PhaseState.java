package Gameplay.Model.Phases;

import Gameplay.Controller.PhaseStateController;
import Gameplay.Model.Utility.Actions.Action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface  PhaseState {

    void advance();
    PhaseStateController getPhaseController();

}
