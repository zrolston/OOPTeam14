package Gameplay.Controller;

import Gameplay.Model.Actions.Action;
import Gameplay.Views.MainView.MainView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jordi on 4/13/2017.
 */
public abstract class PhaseStateController  {

    protected void clearPanels(MainView mainView){
        mainView.hideAllPhaseSubViews();
        mainView.dettachAllControllers();
//        mainView.getDisplay().setFocusable(false);
    }

    public void activateController(MainView mainView){
        mainView.getEndPhaseButton().setPhaseLabel(toString());
        clearPanels(mainView);
        activateState(mainView);
    }

    public abstract void activateState(MainView mainView);

}
