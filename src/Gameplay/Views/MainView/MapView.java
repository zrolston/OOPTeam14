package Gameplay.Views.MainView;

import Gameplay.Controller.CameraController;
import Gameplay.Model.Visitors.GameMapDrawingVisitor;
import Gameplay.Views.Drawers.*;
import Gameplay.Views.Utility.*;
import MapBuilder.Model.Map.IViewMap;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class MapView extends JPanel {

    private RenderingThread renderingThread;
    private BufferedImage[][] tileImages;
    private List<ImageWithLocation> transporterImages;
    private List<ImageWithLocation> producerImages;
    private List<ImageWithLocation> goodsImages;
    private CursorState cursorState = CursorState.getInstance();

    public void updateTileImages(IViewMap map) {
        GameMapDrawingVisitor drawingVisitor = new GameMapDrawingVisitor();
        map.accept(drawingVisitor);
        tileImages = drawingVisitor.getImageArray();
    }

    public void updateTransporterImages() {
        AllTransporterDrawer atd = new AllTransporterDrawer();
        transporterImages = atd.getAllTransporterImages();
    }

    public void updateProducerImages() {
        AllProducerDrawer apd = new AllProducerDrawer();
        producerImages = apd.getAllProducerImages();
    }

    public void updateGoodsImages() {
        AllGoodDrawer agd = new AllGoodDrawer();
        goodsImages = agd.getAllGoodImages();
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
        g.drawImage(ImageLoader.getImage("GAME_BACKGROUND"), 0, 0, getWidth(), getHeight(), null);
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

        //Tile Marker
//        GridDrawer.drawActiveTile(g, CursorState.getInstance().getActiveTile());

        //Region Marker Test
        Polygon region = cursorState.getRegionArea();
        if(region != null && cursorState.isMarkerActive())
            GridDrawer.drawActiveRegion(g, region);

        if (transporterImages != null) {
            for (ImageWithLocation image : transporterImages)
                image.draw(g);
        }

        if (goodsImages != null) {
            for (ImageWithLocation image : goodsImages)
                image.draw(g);   
        }

        if (producerImages != null) {
            for (ImageWithLocation image : producerImages)
                image.draw(g);
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
