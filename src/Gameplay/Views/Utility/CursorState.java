/**--------------------------------------------------------------------------------------
|   CursorState Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: CursorState keeps track of the position and state of the cursor and
|   all its properties such as being pressed and kind of marker. (Adjusted for the GamePlay Map)
---------------------------------------------------------------------------------------*/


package Gameplay.Views.Utility;
import Gameplay.Model.Region.Region;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;

public class CursorState {

    private static CursorState ourInstance = new CursorState();
    private PixelPoint cursor = new PixelPoint(0,0);
    private HexLocation activeTile;
    private boolean markerActive = true;
    private Region activeRegion = null;
    private PolygonPointSet pointSet = null;
    private Polygon regionArea = null;
    private String regionCode = "";

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
}