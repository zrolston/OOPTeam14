/**--------------------------------------------------------------------------------------
|   CursorState Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: CursorState keeps track of the position and state of the cursor and
|   all its properties such as being pressed and kind of marker. (Adjusted for the GamePlay Map)
---------------------------------------------------------------------------------------*/


package Gameplay.Views.Utility;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.GameModelFacade;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;

public class CursorState {

    //Road Drawing functionality
    private static boolean isBridge = false;
    private static boolean controlActive = false;
    private static boolean drawingRoad = false;
    private static PixelPoint startRoad = null, endRoad = null;
    private static Region startRegion = null, endRegion = null;


    private static CursorState ourInstance = new CursorState();
    private PixelPoint cursor = new PixelPoint(0,0);
    private HexLocation activeTile;
    private boolean markerActive = true;
    private Region activeRegion = null;
    private PolygonPointSet pointSet = null;
    private Polygon regionArea = null;
    private String regionCode = "";

    //Testing executors
    public static Executor executor = null;


    //Getters
    public static CursorState getInstance() {
        return ourInstance;
    }
    public Region getActiveRegion() { return activeRegion; }
    public Polygon getRegionArea() { return regionArea; }
    public PolygonPointSet getPointSet() { return pointSet; }
    public PixelPoint getCursor() { return cursor.clone(); }
    public boolean isMarkerActive(){ return markerActive; }
    public String getRegionCode() { return regionCode; }
    public HexLocation getActiveTile() {
        return activeTile;
    }


    //Setters
    public void setPointSet(PolygonPointSet pointSet) { this.pointSet = pointSet; }
    public void setRegionCode(String regionCode) { this.regionCode = regionCode; }
    public void setActiveRegion(Region activeRegion) { this.activeRegion = activeRegion; }
    public void setRegionArea(Polygon regionArea) { this.regionArea = regionArea; }
    public void setActiveTile(HexLocation activeTile) { this.activeTile = activeTile; }
    public void setMarkerActive(boolean markerActive) { this.markerActive = markerActive; }

    private CursorState() {
        cursor = new PixelPoint(0,0);
        activeTile = new HexLocation(0,0);
    }


    public void setCursor(PixelPoint cursor) { this.cursor = cursor; }
    public void setCursor(int x, int y) {
        cursor.setY(x);
        cursor.setY(y);
    }


    //Road Drawing Functionality
    public void startDrawingRoad(PixelPoint point){
        startRoad = point;
        startRegion = activeRegion;
        drawingRoad = true;
    }

    public void stopDrawingRoad(){
        endRegion = activeRegion;
        drawingRoad = false;
        decideBuild();
    }

    public static void setEndRoad(PixelPoint endRoad) {
        CursorState.endRoad = endRoad;
    }

    public Region[] getDroppedRegions(){
        if(startRegion != null && endRegion != null){
            return new Region[]{startRegion, endRegion};
        }
        return new Region[]{};
    }

    public PixelPoint[] getDrawingPoints(){
        if(startRoad != null && endRoad != null){
            return new PixelPoint[]{startRoad, endRoad};
        }
        return new PixelPoint[]{};
    }

    public static boolean isControlActive() { return controlActive; }
    public static void setControlActive(boolean controlActive) { CursorState.controlActive = controlActive; }
    public static boolean isDrawingRoad() { return drawingRoad; }
    public static boolean isIsBridge() { return isBridge; }
    public static void setIsBridge(boolean isBridge) { CursorState.isBridge = isBridge; }

    private void decideBuild(){
        GameModelFacade gameModelFacade = GameModelFacade.getInstance();
        Region[] rs = getDroppedRegions();

        if(!isBridge) {
            gameModelFacade.generateRoad(rs[0], rs[1]);
        }else{
            gameModelFacade.generateBridge(rs[0], rs[1]);
        }
    }


}