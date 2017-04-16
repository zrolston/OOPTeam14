/**-------------------------------------------------------------------------------------
|	CameraController Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Takes care of Camera related movements and shifts on the viewport.
|   Also makes hovering on Tiles and Regions work dynamically.
---------------------------------------------------------------------------------------*/

package Gameplay.Controller;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.Utility.*;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class CameraController implements MouseMotionListener, MouseListener{

    private Camera camera = Camera.getInstance();
    private CursorState cursorState = CursorState.getInstance();
    private GameMap map = null;

    @Override
    public void mouseDragged(MouseEvent e) {
        PixelPoint point = new PixelPoint(e.getX(), e.getY());
        camera.move(point);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //Hovering goes here
        updateActiveTile(e);
        updateRegion(e);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        camera.recordPress(new PixelPoint(e.getX(), e.getY()));
        cursorState.setMarkerActive(false);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        camera.releasePress();
        cursorState.setMarkerActive(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    public void updateActiveTile(MouseEvent e){
        HexLocation location = PixelMap.getHexLocationAtPixelPoint(new PixelPoint(e.getX(), e.getY()));
        cursorState.setActiveTile(location);
    }


    public void updateRegion(MouseEvent e){
        //Set up Map if needed
        if(map == null){
            map = GameModelFacade.getInstance().debugGetMap();
        }

        ILocation location = cursorState.getActiveTile();
        if(location.getRow() >= 0 && location.getCol() >= 0) {
            //Get locations of current Tile
            GameTile active = map.getTileAt(location);
            //River Type and Rotations from tile
            Integer riverType = active.getRiverType();
            Integer rotation = active.getRotationNumber();
            List<PolygonPointSet> polygonPoints = PolygonUtility.getRegionsByType(new Integer(riverType));
            updateCursorRegion(polygonPoints, e, rotation);
        }
    }


    public void updateCursorRegion(List<PolygonPointSet> polygonPoints, MouseEvent e, Integer rotation){
        PixelPoint origin = PixelMap.getMapTileOrigin(cursorState.getActiveTile());
        Point current = new Point(e.getX(), e.getY());
        for(PolygonPointSet pointSet: polygonPoints){
            pointSet.setCurrRotation(rotation);
            Polygon polygon = pointSet.getPolygon(origin);
            if(polygon.contains(current))
                cursorState.setRegionArea(polygon);
        }
    }
}
