package Gameplay.Controller.PhaseStateControllers.MovementStateControllers;

import Gameplay.Views.MainView.MainView;

/**
 * Created by jordi on 4/15/2017.
 */
public interface MovementState {
    void advance();
    void update(MainView mainView);
}
