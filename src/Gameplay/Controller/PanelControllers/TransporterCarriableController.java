package Gameplay.Controller.PanelControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.MainView.MainView;
import Gameplay.Views.MainView.TransporterCarriableView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jordi on 4/15/2017.
 */
public class TransporterCarriableController implements MainViewController, MouseListener {
    TransporterCarriableView view;
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();

    private TransporterCarriableView getView(MainView mainView) {
        if (viewIsNull(view)) {
            view = mainView.getTransporterCarriableView();
        }
        return view;
    }

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
    public void activateController(MainView mainView) {

        if (viewIsNull(view)) {
            view = getView(mainView);
            resume();
        }
        else {
            resume();
        }
    }

    private boolean viewIsNull(JPanel view) {
        return view == null;
    }

    private void attachView(JPanel view) throws Exception {

        if (viewIsNull(view)) {
            view.addMouseListener(this);
        }
        throw new Exception("The view that was tried to be attached was null");
    }

    private void resume(){
        try {
            attachView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
