package Gameplay.Views.MainView;

import Gameplay.Controller.CameraController;
import Gameplay.Model.Visitors.GameMapDrawingVisitor;
import Gameplay.Model.Visitors.GameTileDrawingVisitor;
import Gameplay.Views.Utility.PolygonUtility;
import Gameplay.Views.Utility.PixelMap;
import Gameplay.Views.Utility.RenderingThread;
import MapBuilder.Model.Map.IViewMap;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Views.Drawers.TileInternalDrawer;
import MapBuilder.Views.Utility.PixelPoint;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class MapView extends JPanel {

    private RenderingThread renderingThread;
    private ILocation[][] map;
    private BufferedImage[][] tileImages;
    private int size = 50;

    public void updateTileImages(IViewMap map) {
        GameMapDrawingVisitor drawingVisitor = new GameMapDrawingVisitor();
        map.accept(drawingVisitor);
        tileImages = drawingVisitor.getImageArray();
    }

    public MapView(){
        map = new HexLocation[size][size];
        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = new HexLocation(i,j);
            }
        }
        setLayout(null);
        setBounds(0,0,PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        setVisible(true);

        //Add Camera Movement Controller
        CameraController cameraController = new CameraController();
        addMouseMotionListener(cameraController);
        addMouseListener(cameraController);

        renderingThread = new RenderingThread(this, 30);
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                PixelPoint center = PixelMap.getMapTileOrigin(map[i][j]);
                Polygon hexaTile = PolygonUtility.getHexagon(center);
                g.drawPolygon(hexaTile);
            }
        }

        if (tileImages == null)
            return;
        for (int i = 0; i < tileImages.length; i++) {
            for (int j = 0; j < tileImages[i].length; j++) {
                if (MapBuilder.Views.Utility.PixelMap.isTileVisible(new HexLocation(i, j))) {
                    PixelPoint origin = MapBuilder.Views.Utility.PixelMap.getMapTileOrigin(new HexLocation(i, j));
                    TileInternalDrawer.drawInMap(g, tileImages[i][j], origin);
                }
            }
        }
    }

    public void startRendering(int frameRate){
        renderingThread.setFrameRate(frameRate);
        renderingThread.start();
    }

    public void stopRendering(){
        renderingThread.interrupt();
    }
}
