package MapBuilder.Controllers.MouseListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import MapBuilder.Model.ModelFacade;
import MapBuilder.Model.Map.BuildMap;
import MapBuilder.Model.Tile.BuildTile;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.MapEditor.MapEditorView;
import MapBuilder.Views.MapEditor.MapView.MapSubsectionView;
import MapBuilder.Views.MapEditor.TileSelection.CurrentSelectionView;
import MapBuilder.Views.MapEditor.TileSelection.TileSelectionView;
import MapBuilder.Views.Utility.CursorState;
import MapBuilder.Views.Utility.PixelMap;
import MapBuilder.Views.Utility.PixelPoint;

public class TileSelectionMouseListener implements MouseMotionListener, MouseListener {

    TileSelectionView view;
    CursorState cursorState = CursorState.getInstance();
    CurrentSelectionView currentSelectionView;
    MapSubsectionView mapSubsectionView;
    MapEditorView mapEditorView;
    ModelFacade modelFacade;

    private boolean mousePressed;

    public TileSelectionMouseListener(TileSelectionView tileSelectionView, CurrentSelectionView currentSelectionView, 
    		MapSubsectionView mapSubsectionView, MapEditorView mapEditorView) {
        this.view = tileSelectionView;
        this.currentSelectionView = currentSelectionView;
        this.mapSubsectionView = mapSubsectionView;
        this.mapEditorView = mapEditorView;
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
            mapEditorView.updateImages();
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
