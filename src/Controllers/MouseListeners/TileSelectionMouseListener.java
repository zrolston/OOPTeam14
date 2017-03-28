package Controllers.MouseListeners;

import Model.Map.BuildMap;
import Model.ModelFacade;
import Model.Tile.BuildTile;
import Model.Tile.Tile;
import Model.Utility.HexLocation;
import Views.MapEditor.MapView.MapSubsectionView;
import Views.MapEditor.TileSelection.CurrentSelectionView;
import Views.MapEditor.TileSelection.TileSelectionView;
import Views.Utility.CursorState;
import Views.Utility.PixelMap;
import Views.Utility.PixelPoint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TileSelectionMouseListener implements MouseMotionListener, MouseListener {

    TileSelectionView view;
    CursorState cursorState = CursorState.getInstance();
    CurrentSelectionView currentSelectionView;
    ModelFacade modelFacade;
    private boolean mousePressed;

    public TileSelectionMouseListener(TileSelectionView tileSelectionView, CurrentSelectionView currentSelectionView) {
        this.view = tileSelectionView;
        this.currentSelectionView = currentSelectionView;
        modelFacade = ModelFacade.getInstance();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed = true;
//        cursorState.setDragged(e.getX(), e.getY());
//        cursorState.startDraggingTile();
//        cursorState.setDraggedImage(currentSelectionView.getSelectedTileImage());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
        if(cursorState.isDraggingTile()){
            BuildTile tile = (BuildTile)currentSelectionView.getSelectedTile();
            modelFacade.placeTile(
                    tile,
                    PixelMap.getHexLocationAtPixelPoint(
                            new PixelPoint(e.getX(), e.getY())
                    )
            );
            MapSubsectionView.updateCachedImages(BuildMap.getInstance());
        }
        updateActiveTile(e);
        cursorState.setDragged(e.getX(), e.getY());
        cursorState.stopDraggingTile();
        cursorState.setDraggedImage(null);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(mousePressed){
            cursorState.setDragged(e.getX(), e.getY());
            cursorState.startDraggingTile();
            cursorState.setDraggedImage(currentSelectionView.getSelectedTileImage());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(cursorState.isDraggingTile()){
            cursorState.setDragged(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void updateActiveTile(MouseEvent e){
        HexLocation location = PixelMap.getHexLocationAtPixelPoint(new PixelPoint(e.getX(), e.getY()));
        cursorState.setActiveTile(location);
    }
}
