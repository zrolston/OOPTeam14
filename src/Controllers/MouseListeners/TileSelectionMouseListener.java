package Controllers.MouseListeners;

import Views.MapEditor.MapView.MapSubsectionView;
import Views.MapEditor.TileSelection.CurrentSelectionView;
import Views.MapEditor.TileSelection.TileSelectionView;
import Views.Utility.CursorState;
import Views.Utility.PixelPoint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Willie on 3/26/2017.
 */
public class TileSelectionMouseListener implements MouseMotionListener, MouseListener {

    TileSelectionView view;
    CursorState cursorState = CursorState.getInstance();

    public TileSelectionMouseListener(TileSelectionView tileSelectionView) {
        this.view = tileSelectionView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        cursorState.setDragged(e.getX(), e.getY());
        cursorState.startDraggingTile();
        cursorState.setDraggedImage(CurrentSelectionView.getSelectedTile());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
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
}
