/**-------------------------------------------------------------------------------------
|	TileInternalDrawer Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Gameplay.Views.Drawers;

import Gameplay.Views.Utility.Camera;
import Gameplay.Views.Utility.PixelMap;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileInternalDrawer {

    private static Camera camera = Camera.getInstance();

    public static void drawInMap(Graphics g, BufferedImage tile, PixelPoint origin){
    	g.drawImage(tile, origin.getX(), origin.getY(), (int)(PixelMap.TILE_FULL_WIDTH*1.0225), (int)(PixelMap.TILE_HEIGHT*1.0225), null);
    }

}
