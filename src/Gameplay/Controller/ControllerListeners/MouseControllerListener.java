package Gameplay.Controller.ControllerListeners;

import Gameplay.Controller.MainViewController;
import Gameplay.Views.MainView.MainView;

import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * Created by jordi on 4/15/2017.
 */
public abstract class MouseControllerListener implements MainViewController, MouseListener {

    /**
     * use this function to get the appropriate view for the controller
     * @return mainview.getNeededView()
     */
    protected abstract JPanel getView(MainView mainView);

    @Override
    public void activateController(MainView mainView) {
        JPanel view = getView(mainView);
        attachView(view);
    }

    private void attachView(JPanel view) {
        if (!viewIsNull(view)) {
            view.addMouseListener(this);
        }
    }

    private boolean viewIsNull(JPanel view) {
        return view == null;
    }

}
