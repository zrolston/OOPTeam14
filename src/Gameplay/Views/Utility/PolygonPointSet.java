/**-------------------------------------------------------------------------------------
|	PolygonPointSet Class: Created by Alejandro Chavez on 4/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the DataSet of a Polygon without compromising any shifts or
|   rotation.
---------------------------------------------------------------------------------------*/
package Gameplay.Views.Utility;

import MapBuilder.Views.Utility.PixelPoint;
import java.awt.Point;
import java.awt.Polygon;
import java.util.*;


public class PolygonPointSet{

    private Map<Integer, List<Point>> points = new HashMap<>();
    private Point center = new Point(PixelMap.TILE_FULL_WIDTH/2, PixelMap.TILE_HEIGHT/2);
    private double[] rotations = new double[]{0, 60, 120, 180, 240, 300};
    private Integer currRotation = 0;

    public PolygonPointSet(List<Point> points){
        //Generates all possible rotations based on 60degree increments
        for(int i=0; i<6; i++){
            this.points.put(new Integer(i), rotatePolygon(points, center, rotations[i]));
        }
    }

    //Setters and getters
    public Integer getCurrRotation() { return currRotation; }
    public void setCurrRotation(Integer currRotation) { this.currRotation = currRotation; }



    //Generate the Polygon delimited by the points
    //Uses currLocation to determine the geometry of the Polygons
    //--------------------------------------------------------------------------
    public Polygon getPolygon(PixelPoint origin){
        Polygon p = new Polygon();
        for (Point point: points.get(currRotation)){
            p.addPoint((int)point.getX()+origin.getX(), (int)point.getY()+origin.getY());
        }
        return p;
    }
    public Polygon getPolygon(){
        return getPolygon(new PixelPoint(0,0));
    }
    public Polygon getPolygon(int xOffset, int yOffset){
        return getPolygon(new PixelPoint(xOffset,yOffset));
    }


    //Rotation Helper functions
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

        Point newPoint = new Point();
        newPoint.x = center.x + (int) (dx*cosAngle-dy*sinAngle);
        newPoint.y = center.y + (int) (dx*sinAngle+dy*cosAngle);
        return newPoint;
    }

//    public Point centroid()  {
//        List<Point> sets =
//        double centroidX = 0, centroidY = 0;
//
//        for(Point knot : knots) {
//            centroidX += knot.getX();
//            centroidY += knot.getY();
//        }
//        return new Point(centroidX / knots.size(), centroidY / knots.size());
//    }
}
