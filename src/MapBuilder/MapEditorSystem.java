package MapBuilder;

import Gameplay.Views.Display;
import MapBuilder.Controllers.TileSelectionController;
import MapBuilder.Model.Map.BuildMap;
import MapBuilder.Model.Map.PlacementManager;
import MapBuilder.Model.ModelFacade;
import MapBuilder.Views.MapEditor.MapView.MapSubsectionView;
import MapBuilder.Views.MapEditorDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.*;


public class MapEditorSystem {

    MapEditorDisplay display;
    Timer timer;
    private MapSubsectionView mapView;
    private Display displayFrame;

    public MapEditorSystem( Display displayFrame ) {

        this.displayFrame = displayFrame;
        BuildMap.getInstance();
        ModelFacade.initialize(new PlacementManager());
        display = new MapEditorDisplay( displayFrame );

        // TODO:  initialize somewhere else
        TileSelectionController tileSelectionController = new TileSelectionController(display.getTileSelectionView());

        mapView = display.getMapSubsectionView();

        timer = new Timer(30, new ActionListener()
        {
            public void actionPerformed( ActionEvent e)
            {
                timer.stop();

                mapView.repaint();

                timer.restart();
            }
        } );

    }

    public void start() {
        timer.start();
    }







}

