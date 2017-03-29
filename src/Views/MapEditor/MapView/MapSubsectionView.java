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
import Views.Utility.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapSubsectionView extends JPanel {
	private BufferedImage background;
    private BufferedImage image;
    private BufferedImage[][] tileImages;
    private CursorState cursorState = CursorState.getInstance();
    private static boolean cachedImagesUpdated = false;

    public void updateCachedImages(IViewMap map) {
        MapDrawingVisitor drawingVisitor = new MapDrawingVisitor();
        map.accept(drawingVisitor);
        tileImages = drawingVisitor.getImageArray();
        updateImage();
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

        g.drawImage(image, 0, 0, null);

        //Update the Marker
        if(cursorState.isMarkerActive()) {
            if(cursorState.getMarkerType() == CursorState.NORMAL)
                TileOutlineDrawer.drawActiveTile(g, CursorState.getInstance().getActiveTile());
            else if(cursorState.getMarkerType() == CursorState.VALID)
                TileOutlineDrawer.drawValidEdge(g, CursorState.getInstance().getActiveTile());
            else if(cursorState.getMarkerType() == CursorState.INVALID)
                TileOutlineDrawer.drawInvalidEdge(g, CursorState.getInstance().getActiveTile());
        }

        //Update the Dragging of the Tile
        if(cursorState.isDraggingTile()) {
            Camera camera = Camera.getInstance();
            PixelPoint origin = cursorState.getDragged();
            PixelPoint center = new PixelPoint(origin.getX() - (int)(PixelMap.TILE_WIDTH*camera.getScale()), origin.getY() - (int)(PixelMap.TILE_HEIGHT/2*camera.getScale()));
            g.drawImage(cursorState.getDraggedImage(), center.getX(), center.getY(), (int)(PixelMap.TILE_FULL_WIDTH*camera.getScale()), (int)(PixelMap.TILE_HEIGHT*camera.getScale()), null);
        }
    }

    public MapSubsectionView() {
        //Adding some Listeners to test
        ModelFacade modelFacade = ModelFacade.getInstance();
        MapSubsectionMouseListener listener = new MapSubsectionMouseListener(modelFacade, this);
        addMouseListener(listener);
        addMouseMotionListener(listener);

        setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);

        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        background = ImageLoader.getImage("BACKGROUND");

        BuildMap map = BuildMap.getInstance();
        updateCachedImages(map);

        setVisible(true);
    }

    public BufferedImage getImage() {
        return image;
    }

}
