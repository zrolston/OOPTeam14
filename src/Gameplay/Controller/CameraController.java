/**-------------------------------------------------------------------------------------
|	CameraController Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Takes care of Camera related movements and shifts on the viewport.
|   Also makes hovering on Tiles and Regions work dynamically.
---------------------------------------------------------------------------------------*/

package Gameplay.Controller;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Views.Utility.*;
import Gameplay.Views.Utility.PolygonProportions.RegionVertexUtility;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
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
        //Lock Camera in case of Drawing Road
        if(!cursorState.isDrawingRoad()){
            PixelPoint point = new PixelPoint(e.getX(), e.getY());
            camera.move(point);
        }
        else{
            //Hovering goes here
            updateActiveTile(e);
            updateRegion(e);
            PixelPoint now = new PixelPoint(e.getX(), e.getY());
            cursorState.setEndRoad(now);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursorState.setMarkerActive(true);
        //Hovering goes here
        updateActiveTile(e);
        updateRegion(e);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(cursorState.isControlActive() || cursorState.isIsBridge()){
            PixelPoint point = new PixelPoint(e.getX(), e.getY());
            cursorState.startDrawingRoad(point);
        }

        camera.recordPress(new PixelPoint(e.getX(), e.getY()));
        cursorState.setMarkerActive(false);

        //Testing any kind of functionality
        if(SwingUtilities.isRightMouseButton(e)){
            Executor executor = cursorState.executor;
            if(executor != null){
                executor.execute();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(cursorState.isControlActive() || cursorState.isIsBridge()){
            cursorState.stopDrawingRoad();
        }

        //Lock Camera in case of Drawing Road
        if(!cursorState.isDrawingRoad()) {
            camera.releasePress();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) { }

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
        if(location.getRow() >= 0 && location.getCol() >= 0 && location.getRow() < map.getWidth() && location.getCol() < map.getWidth()) {
            //Get locations of current Tile
            GameTile active = map.getTileAt(location);
            //River Type and Rotations from tile
            Integer riverType;
            Integer rotation;
            try {
                riverType = active.getRiverType();
                rotation = active.getRotationNumber();
            }catch (Exception exe){ return; }
            List<PolygonPointSet> polygonPoints = PolygonUtility.getRegionsByType(new Integer(riverType));
            updateCursorRegion(polygonPoints, e, riverType, rotation, active);
        }
    }


    public void updateCursorRegion(List<PolygonPointSet> polygonPoints, MouseEvent e, Integer riverType, Integer rotation, GameTile active){
        PixelPoint origin = PixelMap.getMapTileOrigin(cursorState.getActiveTile());
        Point current = new Point(e.getX(), e.getY());
        int regionIndex = 0;
        for(PolygonPointSet pointSet: polygonPoints){
            pointSet.setCurrRotation(rotation);
            Polygon polygon = pointSet.getPolygon(origin);
            if(polygon.contains(current)) {
                cursorState.setRegionArea(polygon);
                cursorState.setPointSet(pointSet);
                HexaVertex vertex = null;
                try {
                    vertex = RegionVertexUtility.getVertexAt(riverType, rotation, regionIndex);
                }catch(Exception ex){ex.printStackTrace();}
                RegionMap rm = active.getRegionMap();
                cursorState.setActiveRegion(rm.getRegionAt(vertex));
            }
            regionIndex++;
        }
    }

    public void executer(){

    }
}
