package Views.Drawers;
/**-------------------------------------------------------------------------------------
|	TileOutlineDrawer Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: This drawer makes drawing TileShapes easy. It only draws Tile Outlines
|   and not the image itself, this makes the drawer not depend on an preset PNG Image
|   as it can generate Hexagon based clips for a Tile. BEWARE of geometry math below.
---------------------------------------------------------------------------------------*/


import Model.Utility.HexLocation;
import Views.Utility.PixelMap;
import Views.Utility.PixelPoint;
import Views.Utility.Camera;
import java.awt.*;
import java.util.*;


public class TileOutlineDrawer extends Drawer{

    public static void drawInMenu(Graphics g, PixelPoint center){
        //Set Stroke
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        //Draw Hexatile Outline
        Polygon tileShape = getHexagon(center);
        g.drawPolygon(tileShape);
    }

    public static void drawInMap(Graphics g, PixelPoint center){
        //Set Stroke
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        Camera camera = Camera.getInstance();

        //Draw Hexatile Outline
        Polygon tileShape = getHexagon(center, camera.getOrigin().getX(), camera.getOrigin().getY());
        g.drawPolygon(tileShape);
    }


    public static void drawValidEdge(Graphics g, HexLocation tileLocation){
        drawEdge(g, tileLocation, new Color(0, 0, 255));
    }

    public static void drawInvalidEdge(Graphics g, HexLocation tileLocation){
        drawEdge(g, tileLocation, new Color(255, 0, 0));
    }


    private static void drawEdge(Graphics g, HexLocation tileLocation, Color color){
        Camera camera = Camera.getInstance();
        PixelPoint center = PixelMap.getTileCenter(tileLocation, camera);
        Polygon hexatile = getHexagon(center);
        ((Graphics2D)g).setStroke(new BasicStroke(5));

        Color prev = g.getColor();
        g.setColor(color);
        g.drawPolygon(hexatile);
        g.setColor(prev);
    }



    //Gets corner points for a Hexatile
    private static java.util.List<PixelPoint> getHexatilePoints(PixelPoint center, int xOffset, int yOffset){
        java.util.List<PixelPoint> points = new ArrayList<>();
        //Top-Left point
        points.add(new PixelPoint(center.getX() - PixelMap.TILE_WIDTH/2 - xOffset, center.getY() - PixelMap.TILE_HEIGHT/2 - yOffset));
        //Left point
        points.add(new PixelPoint(center.getX() - PixelMap.TILE_WIDTH - xOffset, center.getY() - yOffset));
        //Bottom-Left point
        points.add(new PixelPoint(center.getX() - PixelMap.TILE_WIDTH/2 - xOffset, center.getY() + PixelMap.TILE_HEIGHT/2 - yOffset));
        //Bottom-Right point
        points.add(new PixelPoint(center.getX() + PixelMap.TILE_WIDTH/2 - xOffset, center.getY() + PixelMap.TILE_HEIGHT/2 - yOffset));
        //Right point
        points.add(new PixelPoint(center.getX() + PixelMap.TILE_WIDTH - xOffset, center.getY() - yOffset));
        //Top-Right point
        points.add(new PixelPoint(center.getX() + PixelMap.TILE_WIDTH/2 - xOffset, center.getY() - PixelMap.TILE_HEIGHT/2 - yOffset));
        return points;
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
}
