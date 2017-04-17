package Gameplay.Controller.PanelControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.BuildingController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.UserRequestController;
import Gameplay.Views.MainView.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by jordi on 4/15/2017.
 */
public class WallSelectionController implements MainViewController {

    private BuildingController buildingController;

    public WallSelectionController(BuildingController buildingController) {
        this.buildingController = buildingController;
    }

    @Override
    public void deactivateController() {

    }

    @Override
    public void activateController(MainView mainView) {
        ArrayList<JButton> buttons = mainView.getWallSelectionView().getButtons();
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }
    }

}
