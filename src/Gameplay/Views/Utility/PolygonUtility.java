/**-------------------------------------------------------------------------------------
|	PolygonUtility Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Takes care of the Generation of all relevant Polygons in the game.
|   Hexatiles, Regions, Rivers, and Menu elements are generated here dynamically while
|   taking into account Pixel inputs.
---------------------------------------------------------------------------------------*/

package Gameplay.Views.Utility;
import Gameplay.Views.Utility.PolygonProportions.River1Proportions;
import MapBuilder.Views.Utility.PixelPoint;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PolygonUtility {


    //Maintains the DataSet of a Polygon without compromising any shifts
    public static class PolygonPointSet{
        private List<Point> points;
        public PolygonPointSet(List<Point> points){
            this.points = points;
        }

        public Polygon getPolygon(PixelPoint origin){
            Polygon p = new Polygon();
            for (Point point: points){
                p.addPoint((int)point.getX()+origin.getY(), (int)point.getY()+origin.getY());
            }
            return p;
        }
        public Polygon getPolygon(){
            return getPolygon(new PixelPoint(0,0));
        }
        public Polygon getPolygon(int xOffset, int yOffset){
            return getPolygon(new PixelPoint(xOffset,yOffset));
        }
    }



    static class RegionCode{
        public String code;
        public PolygonPointSet polygon;
    }

    private static Map<String, Map<Integer, RegionCode>> riverTypeToRegions = new HashMap<>();

    public static PolygonPointSet testPolygon, test2;
    public static Polygon getTest(){
        //Initialize Regions
        //River 1
        //---------------------------
        if(testPolygon == null) {
            List<Point> riverPoints = River1Proportions.river;
            testPolygon = new PolygonPointSet(rotatePolygon(riverPoints, new Point(PixelMap.TILE_FULL_WIDTH/2, PixelMap.TILE_HEIGHT/2), 0));
            test2 = new PolygonPointSet(rotatePolygon(River1Proportions.region, new Point(PixelMap.TILE_FULL_WIDTH/2, PixelMap.TILE_HEIGHT/2), 0));
        }

        return testPolygon.getPolygon(150, 150);
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

    //generates Squares based on set center
    public static Rectangle generateSquare(PixelPoint origin, Integer side){
        Rectangle square = new Rectangle();
        square.setBounds(origin.getX(), origin.getY(), side, side);
        return square;
    }


    //Generates a Polygon from a Rectangle
    public static Polygon rectangleToPolygon(Rectangle rect) {
        int[] xpoints = {rect.x, rect.x + rect.width, rect.x + rect.width, rect.x};
        int[] ypoints = {rect.y, rect.y, rect.y + rect.height, rect.y + rect.height};
        return new Polygon(xpoints, ypoints, 4);
    }


    public static Polygon getRegion(PixelPoint point, Polygon region){

        return null;

    }

    public static List<Polygon> getTileRegions(String riverType, Integer rotation){
        return null;
    }


    private static List<Point> rotatePolygon(List<Point> regionPts, Point center, double angle){
        List<Point> pointSet = new ArrayList<>();
        for(Point point: regionPts){
            Point rotatedPoint = rotatePoint(point, center, angle);
            pointSet.add(new Point((int)rotatedPoint.getX(), (int)rotatedPoint.getY()));
        }
        return pointSet;
    }

    private static Point rotatePoint(Point pt, Point center, double angleDeg) {
        double angleRad = (angleDeg/180)*(Math.PI);
        double cosAngle = Math.cos(angleRad );
        double sinAngle = Math.sin(angleRad );
        double dx = (pt.x-center.x);
        double dy = (pt.y-center.y);

        pt.x = center.x + (int) (dx*cosAngle-dy*sinAngle);
        pt.y = center.y + (int) (dx*sinAngle+dy*cosAngle);
        return pt;
    }


}
