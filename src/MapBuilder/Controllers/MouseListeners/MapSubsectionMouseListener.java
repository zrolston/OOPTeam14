/**
 * -------------------------------------------------------------------------------------
 * |	MapSubsectionMouseListener Class: Created by Alejandro Chavez on 3/26/2017.
 * |---------------------------------------------------------------------------------------
 * |   Description: Preliminary Mouse Listener. It does smooth Camera movement but it lacks
 * |   the other MapBuilder.Main functionalities to control the Menu.
 * ---------------------------------------------------------------------------------------
 */

package MapBuilder.Controllers.MouseListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import MapBuilder.Model.ModelFacade;
import MapBuilder.Model.Map.BuildMap;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.MapEditor.MapEditorView;
import MapBuilder.Views.MapEditor.MapView.MapSubsectionView;
import MapBuilder.Views.Utility.Camera;
import MapBuilder.Views.Utility.CursorState;
import MapBuilder.Views.Utility.PixelMap;
import MapBuilder.Views.Utility.PixelPoint;


public class MapSubsectionMouseListener implements MouseMotionListener, MouseListener {

    Camera camera = Camera.getInstance();
    CursorState cursorState = CursorState.getInstance();
    ModelFacade modelFacade;
    MapEditorView mapEditorView;
    MapSubsectionView view;
    
    public MapSubsectionMouseListener(ModelFacade modelFacade) {
        this.modelFacade = modelFacade;
    }
    public MapSubsectionMouseListener(ModelFacade modelFacade, MapSubsectionView mapSubsectionView, MapEditorView mapEditorView) {
        this.mapEditorView = mapEditorView;
    	this.modelFacade = modelFacade;
        view = mapSubsectionView;
    }

    //Continuous Methods
    //-------------------------------------------------------------------
    @Override
    public void mouseDragged(MouseEvent e) {
        camera.move(new PixelPoint(e.getX(), e.getY()));
        view.updateImage();
        cursorState.setCursor(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        updateActiveTile(e);
    }

    //One Event Methods
    //-------------------------------------------------------------------
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(SwingUtilities.isRightMouseButton( e )) {

            HexLocation loc =   PixelMap.getHexLocationAtPixelPoint( new PixelPoint(e.getX(), e.getY())); // tile location
            ModelFacade modelFacade = ModelFacade.getInstance();
            modelFacade.removeTileAt( loc );
            mapEditorView.updateImages();
            view.updateCachedImages(BuildMap.getInstance());

        }


            camera.recordPress(new PixelPoint(e.getX(), e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        camera.releasePress();
        view.updateImage();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        cursorState.setMarkerActive(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        cursorState.setMarkerActive(false);
    }

    public void updateActiveTile(MouseEvent e){
        HexLocation location = PixelMap.getHexLocationAtPixelPoint(new PixelPoint(e.getX(), e.getY()));
        cursorState.setActiveTile(location);
    }
}
