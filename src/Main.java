import Controllers.TileSelectionController;
import Model.Map.BuildMap;
import Model.ModelFacade;
import Views.Display;
import Views.MapEditor.MapView.MapSubsectionView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        BuildMap map= BuildMap.getInstance();
        ModelFacade.initialize(map);
        Display display = new Display();

        // TODO:  initialize somewhere else
        TileSelectionController tileSelectionController = new TileSelectionController(display.getTileSelectionView());

        display.setVisible(true);
        display.repaint();

        MapRender mapRender = new MapRender(display.getMapSubsectionView());
        mapRender.start();
        mapRender.run();
    }




    static class MapRender extends Thread{
        private MapSubsectionView mapView;

        MapRender(MapSubsectionView mapView){
            this.mapView = mapView;
        }

        @Override
        public void run() {
            super.run();

            while (true){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mapView.repaint();
//                System.out.println("running");
            }
        }
    }
}
