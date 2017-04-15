package Gameplay.Controller.PanelControllers;

import Gameplay.Controller.ControllerListeners.MouseControllerListener;
import Gameplay.Controller.MainController;
import Gameplay.Controller.MainViewController;
import Gameplay.Views.MainView.MainView;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * Created by jordi on 4/15/2017.
 */
public class ActionSelectionController extends MouseControllerListener {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    protected JPanel getView(MainView mainView) {
        return mainView.getActionSelectionView();
    }
}
