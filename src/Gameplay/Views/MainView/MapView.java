package Gameplay.Views.MainView;

import Gameplay.Controller.CameraController;
import Gameplay.Views.Utility.PolygonUtility;
import Gameplay.Views.Utility.PixelMap;
import Gameplay.Views.Utility.RenderingThread;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Views.Utility.PixelPoint;
import javax.swing.*;
import java.awt.*;


public class MapView extends JPanel {

    RenderingThread renderingThread;
    ILocation[][] map;
    int size = 50;

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
        g.drawPolygon(PolygonUtility.getTest());
        g.drawPolygon(PolygonUtility.test2.getPolygon());
    }

    public void startRendering(int frameRate){
        renderingThread.setFrameRate(frameRate);
        renderingThread.start();
    }

    public void stopRendering(){
        renderingThread.stop();
    }
}
