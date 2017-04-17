package Gameplay.Controller.PanelControllers.MapSelectionControllers;

import Gameplay.Controller.PanelControllers.MapViewController;
import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Model.Region.Region;
import Gameplay.Views.MainView.MapView;
import Gameplay.Views.Utility.CursorState;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * Created by jordi on 4/15/2017.
 */
public abstract class RegionSelectionController extends MapViewController {

    private Region currentRegion;
    private CursorState cursorState = CursorState.getInstance();


    protected abstract void rightClick();
    protected abstract void leftClick();

    @Override
    protected void attachView(MapView view) throws Exception {

        if (viewIsNull(view)) {
            throw new Exception("The view that was tried to be attached was null");
        }

        view.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        setCurrentRegion(cursorState.getActiveRegion());

        if (isLeftClick(e)) {
            leftClick();
        }
        if (isRightClick(e)) {
            rightClick();
        }
    }

    private boolean isRightClick(MouseEvent e){
        return SwingUtilities.isRightMouseButton(e);
    }

    private boolean isLeftClick(MouseEvent e) {
        return SwingUtilities.isLeftMouseButton(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void setCurrentRegion(Region currentRegion){
        this.currentRegion = currentRegion;
    }

    protected Region getCurrentRegion(){
        return currentRegion;
    }

}
