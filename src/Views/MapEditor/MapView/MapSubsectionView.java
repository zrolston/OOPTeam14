/**-------------------------------------------------------------------------------------
|	MapSubsectionView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: This is the Map Part of the View where the user will drop and move the
|   Tiles to. This View contains the virtual representation of the Map.
---------------------------------------------------------------------------------------*/
package Views.MapEditor.MapView;

import Controllers.MouseListeners.MapSubsectionMouseListener;
import Model.Map.BuildMap;
import Model.Map.IViewMap;
import Model.ModelFacade;
import Model.Utility.HexLocation;
import Model.Visitor.MapDrawingVisitor;
import Views.Drawers.TileInternalDrawer;
import Views.Drawers.TileOutlineDrawer;
import Views.Utility.CursorState;
import Views.Utility.ImageLoader;
import Views.Utility.PixelMap;
import Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapSubsectionView extends JPanel {
	private static BufferedImage background;
    private BufferedImage image;
    private static BufferedImage[][] tileImages;
    private CursorState cursorState = CursorState.getInstance();
    private static boolean cachedImagesUpdated = false;

    public static void updateCachedImages(IViewMap map) {
        MapDrawingVisitor drawingVisitor = new MapDrawingVisitor();
        map.accept(drawingVisitor);
        tileImages = drawingVisitor.getImageArray();
        background = ImageLoader.getImage("BACKGROUND");
        cachedImagesUpdated = true;
    }

    public void updateImage() {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        for (int i = 0; i < tileImages.length; i++) {
            for (int j = 0; j < tileImages[i].length; j++) {
                if (PixelMap.isTileVisible(new HexLocation(i, j))) {
                    PixelPoint origin = PixelMap.getMapTileOrigin(new HexLocation(i, j));
                    TileInternalDrawer.drawInMap(g2, tileImages[i][j], origin);
                }
            }
        }
        g2.dispose();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (cachedImagesUpdated){
            updateImage();
            cachedImagesUpdated = false;
        }

        g.drawImage(image, 0, 0, null);

        //Update the Marker
        if(cursorState.isMarkerActive()) {
            TileOutlineDrawer.drawActiveTile(g, CursorState.getInstance().getActiveTile());
        }

        //Update the Dragging of the Tile
        if(cursorState.isDraggingTile()) {
            PixelPoint point = cursorState.getDragged();
            g.drawImage(cursorState.getDraggedImage(), point.getX(), point.getY(), PixelMap.TILE_FULL_WIDTH, PixelMap.TILE_HEIGHT, null);
        }
    }

    public MapSubsectionView() {
        //Adding some Listeners to test
        ModelFacade modelFacade = ModelFacade.getInstance();
        MapSubsectionMouseListener listener = new MapSubsectionMouseListener(modelFacade, this);
        addMouseListener(listener);
        addMouseMotionListener(listener);

        setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);

        BuildMap map = BuildMap.getInstance();
        updateCachedImages(map);
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        updateImage();
        setVisible(true);
    }

    public BufferedImage[][] getTileImages() {
        return tileImages;
    }

    public BufferedImage getImage() {
        return image;
    }

}
