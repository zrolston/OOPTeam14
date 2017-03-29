package Controllers.MouseListeners;

import Model.Map.BuildMap;
import Model.Map.PlacementManager;
import Model.ModelFacade;
import Model.Tile.BuildTile;
import Model.Utility.HexLocation;
import Views.MapEditor.MapView.MapSubsectionView;
import Views.MapEditor.TileSelection.CurrentSelectionView;
import Views.MapEditor.TileSelection.TileSelectionView;
import Views.Utility.CursorState;
import Views.Utility.PixelMap;
import Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Map;

public class TileSelectionMouseListener implements MouseMotionListener, MouseListener {

    TileSelectionView view;
    CursorState cursorState = CursorState.getInstance();
    CurrentSelectionView currentSelectionView;
    MapSubsectionView mapSubsectionView;
    ModelFacade modelFacade;

    private boolean mousePressed;

    public TileSelectionMouseListener(TileSelectionView tileSelectionView, CurrentSelectionView currentSelectionView, MapSubsectionView mapSubsectionView) {
        this.view = tileSelectionView;
        this.currentSelectionView = currentSelectionView;
        this.mapSubsectionView = mapSubsectionView;
        modelFacade = ModelFacade.getInstance();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getY() > (view.getBounds().getHeight() - view.getBounds().getWidth()))
            mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
        if(cursorState.isDraggingTile()){
            BuildTile tile = (BuildTile)currentSelectionView.getSelectedTile();
            modelFacade.placeTile(
                    tile,
                    PixelMap.getHexLocationAtPixelPoint(
                            getRealMousePosition(new PixelPoint(e.getX(), e.getY()))
                    )
            );
            mapSubsectionView.updateCachedImages(BuildMap.getInstance());
            currentSelectionView.update(0);
            cursorState.setMarkerType(CursorState.NORMAL);
        }
        updateActiveTile(e);
        cursorState.setDragged(e.getX(), e.getY());
        cursorState.stopDraggingTile();
        cursorState.setDraggedImage(null);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        cursorState.setMarkerActive(false);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(mousePressed){
            cursorState.setDragged(e.getX(), e.getY());
            cursorState.startDraggingTile();
            cursorState.setDraggedImage(currentSelectionView.getSelectedTileImage());
        }
        cursorState.setMarkerActive(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        updateActiveTile(e);
        if(cursorState.isDraggingTile()){
            cursorState.setDragged(e.getX() + (int) view.getBounds().getX(), e.getY() + (int) view.getBounds().getY());
            BuildTile tile = (BuildTile)currentSelectionView.getSelectedTile();
            HexLocation location = PixelMap.getHexLocationAtPixelPoint(getRealMousePosition(new PixelPoint(e.getX(), e.getY())));
            if(modelFacade.validateLocation(tile, location)){
                cursorState.setMarkerType(CursorState.VALID);
            }else{
                cursorState.setMarkerType(CursorState.INVALID);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void updateActiveTile(MouseEvent e){
        HexLocation location = PixelMap.getHexLocationAtPixelPoint(getRealMousePosition(new PixelPoint(e.getX(), e.getY())));
        cursorState.setActiveTile(location);
    }

    private PixelPoint getRealMousePosition(PixelPoint p) {
        return new PixelPoint(p.getX() + (int) view.getBounds().getX(), p.getY() + (int) view.getBounds().getY());
    }
}
