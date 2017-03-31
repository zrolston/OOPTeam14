import Controllers.TileSelectionController;
import Model.ModelFacade;
import Model.Map.BuildMap;
import Model.Map.PlacementManager;
import Views.Display;
import Views.MapEditor.MapView.MapSubsectionView;

public class Main {
    public static void main(String[] args) {
        BuildMap.getInstance();
        ModelFacade.initialize(new PlacementManager());
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
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mapView.repaint();
            }
        }
    }
}
