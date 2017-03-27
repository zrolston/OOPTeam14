/**-------------------------------------------------------------------------------------
|	MiniMapView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Minimized representation of the map. Weill most likely run on a different
|   Thread than the main map rendering to evade conflicts.
---------------------------------------------------------------------------------------*/
package Views.MapEditor.MapView;

import Model.Utility.HexLocation;
import Views.Drawers.TileInternalDrawer;
import Views.Utility.PixelMap;
import Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MiniMapView extends JPanel {

    BufferedImage miniMapImage = null;
    BufferedImage[][] tileImages;
    MapSubsectionView mapSubsectionView = null;


    public MiniMapView(MapSubsectionView mapSubsectionView) {
        this.mapSubsectionView = mapSubsectionView;
        double width  = 0.75;
        double height = 0.75;
        setBounds((int)(PixelMap.SCREEN_WIDTH * width), (int)(PixelMap.SCREEN_HEIGHT * height), (int)(PixelMap.SCREEN_WIDTH * (1 - width - 0.0125)), (int)(PixelMap.SCREEN_HEIGHT * (1 - height - 0.0125*2)));
        setBackground(Color.orange);
        setBorder(BorderFactory.createLineBorder(new Color(0xff000000), 1));
        setVisible(true);

        miniMapImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        updateMiniMap();
        redrawMiniMap();
    }

    public void updateMiniMap() {
        this.tileImages = mapSubsectionView.getTileImages();
    }

    public void redrawMiniMap() {

        //TODO: create full map image, scale it down, display in mini map
//        int wholeMapWidth = PixelMap.TILE_WIDTH * tileImages.length;
//        int wholeMapHeight = PixelMap.TILE_HEIGHT * tileImages[0].length;
//        BufferedImage wholeMapImage = new BufferedImage(wholeMapWidth , wholeMapHeight , BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2d = (Graphics2D) wholeMapImage.getGraphics();
//


        // until we do the above, we will just draw map subsection image in mini map
        BufferedImage wholeMapImage = mapSubsectionView.getImage();
        Graphics2D g2 = (Graphics2D) miniMapImage.createGraphics();
        g2.drawImage(wholeMapImage, 0, 0, miniMapImage.getWidth(),  miniMapImage.getHeight(), null);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(miniMapImage, 0, 0, null);
    }

}
