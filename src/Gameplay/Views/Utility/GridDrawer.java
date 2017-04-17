/**-------------------------------------------------------------------------------------
|	GridDrawer Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

package Gameplay.Views.Utility;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;

public class GridDrawer {

    public static void drawActiveRegion(Graphics g, Polygon region){
        //Set Stroke and color
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(new Color(198, 34, 196));
        g.drawPolygon(region);
    }

    public static void drawActiveDestination(Graphics g, Polygon region, Color color, int stroke){
        //Set Stroke and color
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(stroke));
        g2.setColor(color);
        g.drawPolygon(region);
    }

    public static void drawTileGrid(Graphics g, HexLocation tileLocation, Color color){
        //Set Stroke and color
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(color);

        //Draw Hexatile Outline
        PixelPoint origin = PixelMap.getMapTileOrigin(tileLocation);
        PixelPoint center = new PixelPoint(origin.getX()+PixelMap.TILE_FULL_WIDTH/2, origin.getY()+PixelMap.TILE_HEIGHT/2);
        Polygon tileShape = PolygonUtility.getHexagon(center);
        g.drawPolygon(tileShape);
    }
}
