/**-------------------------------------------------------------------------------------
|	PolygonDrawer Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

package Gameplay.Views.Drawers;

import Gameplay.Views.Utility.Camera;
import Gameplay.Views.Utility.PixelMap;
import MapBuilder.Views.Utility.PixelPoint;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PolygonDrawer {

    public static void drawInMap(Graphics g, PixelPoint center){

        //Set Stroke
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.setColor(new Color(0,0,0));
        Camera camera = Camera.getInstance();

        //Draw Hexatile Outline
        Polygon tileShape = getHexagon(center, camera.getOrigin().getX(), camera.getOrigin().getY());
        for(PixelPoint p : getHexatilePoints(center,0,0)){
            System.out.println(p);
        }
        g.drawPolygon(tileShape);
    }

    //Returns the Hexagon formed by the joining the corner points and a ZERO offset
    public static Polygon getHexagon(PixelPoint center){
        Polygon polygon = new Polygon();
        for(PixelPoint point: getHexatilePoints(center, 0, 0)){
            polygon.addPoint(point.getX(), point.getY());
        }
        return polygon;
    }

    //Returns the Hexagon formed by the joining the corner points taking camera offset into account
    public static Polygon getHexagon(PixelPoint center, int xOffset, int yOffset){
        Polygon polygon = new Polygon();
        for(PixelPoint point: getHexatilePoints(center, xOffset, yOffset)){
            polygon.addPoint(point.getX(), point.getY());
        }
        return polygon;
    }

    //Gets corner points for a Hexatile
    private static List<PixelPoint> getHexatilePoints(PixelPoint center, int xOffset, int yOffset){
        java.util.List<PixelPoint> points = new ArrayList<>();
        //Top-Left point
        points.add(new PixelPoint(center.getX() - (PixelMap.TILE_WIDTH/2) - xOffset, center.getY() - (PixelMap.TILE_HEIGHT/2) - yOffset));
        //Left point
        points.add(new PixelPoint(center.getX() - (PixelMap.TILE_WIDTH) - xOffset, center.getY() - yOffset));
        //Bottom-Left point
        points.add(new PixelPoint(center.getX() - (PixelMap.TILE_WIDTH/2) - xOffset, center.getY() + (PixelMap.TILE_HEIGHT/2) - yOffset));
        //Bottom-Right point
        points.add(new PixelPoint(center.getX() + (PixelMap.TILE_WIDTH/2) - xOffset, center.getY() + ((PixelMap.TILE_HEIGHT/2) - yOffset)));
        //Right point
        points.add(new PixelPoint(center.getX() + (PixelMap.TILE_WIDTH) - xOffset, center.getY() - yOffset));
        //Top-Right point
        points.add(new PixelPoint(center.getX() + (PixelMap.TILE_WIDTH/2) - xOffset, center.getY() - (PixelMap.TILE_HEIGHT/2) - yOffset));
        return points;
    }


}
