package Gameplay.Controller;

import Gameplay.Views.MainView.MainView;

/**
 * Created by jordi on 4/15/2017.
 */
public interface MainViewController {
    void activateController(MainView mainView);
    void deactivateController();
}
