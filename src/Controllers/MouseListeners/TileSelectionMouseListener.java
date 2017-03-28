package Controllers.MouseListeners;

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

    public TileSelectionMouseListener(TileSelectionView tileSelectionView, CurrentSelectionView currentSelectionView) {
        this.view = tileSelectionView;
        this.currentSelectionView = currentSelectionView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        cursorState.setDragged(e.getX(), e.getY());
        cursorState.setDraggedImage(currentSelectionView.getSelectedTile());
        cursorState.startDraggingTile();
        cursorState.setDraggedImage(currentSelectionView.getSelectedTile());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
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

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(cursorState.isDraggingTile()){
            System.out.println();
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
