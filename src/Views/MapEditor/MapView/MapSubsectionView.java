/**-------------------------------------------------------------------------------------
|	MapSubsectionView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: This is the Map Part of the View where the user will drop and move the
|   Tiles to. This View contains the virtual representation of the Map.
---------------------------------------------------------------------------------------*/
package Views.MapEditor.MapView;

import Controllers.KeyboardListeners.EditorKeyboardListener;
import Controllers.MouseListeners.EditorMouseListener;
import Model.Map.BuildMap;
import Model.Map.IViewMap;
import Model.ModelFacade;
import Model.Utility.HexLocation;
import Model.Visitor.MapDrawingVisitor;
import Views.Drawers.TileInternalDrawer;
import Views.Drawers.TileOutlineDrawer;
import Views.Utility.PixelMap;
import Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapSubsectionView extends JPanel {

    BufferedImage image;
    BufferedImage[][] tileImages;
    MapDrawingVisitor drawingVisitor;
    IViewMap map;

    public void updateTileImages(IViewMap map) {
        //TODO: update tileImages with MapDrawingVisitor
    }

    public void updateImage() {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        //TODO: update image with tileImages
    }


    //This method is temporary until we load the real Map
    public void updateCachedMap(){
        map.accept(drawingVisitor);
        tileImages = drawingVisitor.getImageArray();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);

        for (int i = 0; i < tileImages.length; i++) {
            for (int j = 0; j < tileImages[i].length; j++) {
//                PixelPoint origin = PixelMap.getMapTileOrigin(new HexLocation(i, j));
//                TileInternalDrawer.drawInMap(g, tileImages[i][j], origin);

                PixelPoint center = PixelMap.getTileCenter(new HexLocation(i, j));
                TileOutlineDrawer.drawInMap(g, center);
            }
        }
    }

    public MapSubsectionView() {
        //Setting up visitor and Map
        map = new BuildMap(21, 21);
        drawingVisitor = new MapDrawingVisitor(new HexLocation(0,0), new HexLocation(20, 20));
        updateCachedMap();

        //Adding some Listeners to test
        ModelFacade modelFacade = new ModelFacade(null);
        EditorMouseListener listener = new EditorMouseListener(modelFacade);
        addMouseListener(listener);
        addMouseMotionListener(listener);

        setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        setBackground(Color.blue);
        setVisible(true);

        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

//        Graphics2D g2 = (Graphics2D) image.getGraphics();
//        g2.setColor( new Color(255, 255, 255)  );
//        g2.fillRect( 0, 0, image.getWidth(), image.getHeight() );

    }
}
