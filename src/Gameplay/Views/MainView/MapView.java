package Gameplay.Views.MainView;

import Gameplay.Controller.CameraController;
import Gameplay.Model.Visitors.GameMapDrawingVisitor;
import Gameplay.Views.Drawers.AllTransporterDrawer;
import Gameplay.Views.Drawers.ImageWithLocation;
import Gameplay.Views.Utility.PixelMap;
import Gameplay.Views.Utility.RenderingThread;
import MapBuilder.Model.Map.IViewMap;
import MapBuilder.Model.Utility.HexLocation;
import Gameplay.Views.Drawers.TileInternalDrawer;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class MapView extends JPanel {

    private RenderingThread renderingThread;
    private BufferedImage[][] tileImages;
    private List<ImageWithLocation> transporterImages;

    public void updateTileImages(IViewMap map) {
        GameMapDrawingVisitor drawingVisitor = new GameMapDrawingVisitor();
        map.accept(drawingVisitor);
        tileImages = drawingVisitor.getImageArray();
    }

    public void updateTransporterImages() {
        AllTransporterDrawer atd = new AllTransporterDrawer();
        transporterImages = atd.getAllTransporterImages();
    }

    public MapView(){
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (tileImages == null)
            return;
        for (int i = 0; i < tileImages.length; i++) {
            for (int j = 0; j < tileImages[i].length; j++) {
                if (PixelMap.isTileVisible(new HexLocation(i, j))) {
                    PixelPoint origin = PixelMap.getMapTileOrigin(new HexLocation(i,j));
                    TileInternalDrawer.drawInMap(g, tileImages[i][j], origin);
                }
            }
        }

        for (ImageWithLocation image : transporterImages)
            image.draw(g);
    }

    public void startRendering(int frameRate){
        renderingThread.setFrameRate(frameRate);
        renderingThread.start();
    }

    public void stopRendering(){
        renderingThread.interrupt();
    }
}
