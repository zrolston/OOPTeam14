package Gameplay.Controller.PanelControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Views.MainView.MainView;
import Gameplay.Views.MainView.MapView;

import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * Created by jordi on 4/15/2017.
 */
public abstract class MapViewController implements MainViewController, MouseListener {

    private MapView mapView;
    private MainView mainView;
    protected abstract void attachView(JPanel view) throws Exception;
    protected abstract void resume();

    @Override
    public void activateController(MainView mainView) {

        if (viewIsNull(mapView)) {
            mapView = setMapView(mainView);
            this.mainView=mainView;
        }
        try {
            attachView(mapView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resume();
    }

    protected MapView setMapView(MainView mainView) {
        if (viewIsNull(mapView)) {
            mapView = mainView.getMapView();
        }
        return mapView;
    }

    protected boolean viewIsNull(JPanel view) {
        return view == null;
    }
    protected void makeViewVisible() {
        mapView.setVisible(true);
    }
    protected MapView getMapView() {
        return mapView;
    }
    public MainView getMainView() {
        return mainView;
    }
}
