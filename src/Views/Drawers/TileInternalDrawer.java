/**-------------------------------------------------------------------------------------
|	TileInternalDrawer Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views.Drawers;

import Model.Utility.Location;
import Model.Utility.PixelMap;
import Model.Utility.PixelPoint;
import Views.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileInternalDrawer extends Drawer{

    private static Camera camera = Camera.getInstance();

    public static void drawInMap(Graphics g, BufferedImage tile, PixelPoint origin){
        g.drawImage(tile, origin.getX(), origin.getY(), (int)(PixelMap.TILE_WIDTH*camera.getScale()), (int)(PixelMap.TILE_FULL_WIDTH*camera.getScale()), null);
    }

    public static void drawInMap(Graphics g, BufferedImage tile, Location location){

//        g.drawImage();
    }

}
