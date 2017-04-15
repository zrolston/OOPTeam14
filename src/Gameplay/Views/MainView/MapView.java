package Gameplay.Views.MainView;

import Gameplay.Controller.CameraController;
import Gameplay.Views.Drawers.PolygonDrawer;
import Gameplay.Views.Utility.PixelMap;
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
                Polygon hexaTile = PolygonDrawer.getHexagon(center);
                g.drawPolygon(hexaTile);
            }
        }
    }

    public void startRendering(int frameRate){
        renderingThread.setFrameRate(frameRate);
        renderingThread.start();
    }

    public void stopRendering(){
        renderingThread.stop();
    }


    class RenderingThread extends Thread{
        private Component view;
        private int frameRate;

        public RenderingThread(Component view, int frameRate){
            this.view = view;
            this.frameRate = frameRate;
        }

        public void setFrameRate(int frameRate) { this.frameRate = frameRate; }
        public int getFrameRate() { return frameRate; }

        public void run(){
            while(true){
                try {
                    Thread.sleep(1000/frameRate);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.repaint();
            }
        }
    }
}
