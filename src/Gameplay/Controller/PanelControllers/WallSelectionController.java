package Gameplay.Controller.PanelControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.BuildingController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.UserRequestController;
import Gameplay.Views.MainView.MainView;
import MapBuilder.Model.Utility.HexaIndex;

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
        buttons.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buildingController.buildWall(HexaIndex.createIndex(1));
                } catch (Exception d) {}
            }
        });
        buttons.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buildingController.buildWall(HexaIndex.createIndex(2));
                } catch (Exception d) {}
            }
        });
        buttons.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buildingController.buildWall(HexaIndex.createIndex(3));
                } catch (Exception d) {}
            }
        });
        buttons.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buildingController.buildWall(HexaIndex.createIndex(4));
                } catch (Exception d) {}
            }
        });
        buttons.get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buildingController.buildWall(HexaIndex.createIndex(5));
                } catch (Exception d) {}
            }
        });
        buttons.get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buildingController.buildWall(HexaIndex.createIndex(6));
                } catch (Exception d) {}
            }
        });
    }

}
