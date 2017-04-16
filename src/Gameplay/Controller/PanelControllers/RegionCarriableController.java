package Gameplay.Controller.PanelControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Model.Iterators.CarriableIterator;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Views.MainView.MainView;
import Gameplay.Views.MainView.RegionCarriableView;
import Gameplay.Views.Utility.CursorState;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jordi on 4/15/2017.
 */
public abstract class RegionCarriableController implements MainViewController, MouseListener {
    private MainView mainView;
    private RegionCarriableView view;
    private Carriable currentCarriable;
    private Region currentRegion;
    private int index = -1;
    private CursorState cursorState = CursorState.getInstance();
    CarriableIterator carrIt;

    protected abstract void attachView(JPanel view) throws Exception;

    /**
     * you might want to showPanel() when using this class to see the panel
     * the panel is not activated automatically
     */
    protected abstract void resume();

    protected abstract void suspend();

    protected abstract void carriableClick();

    @Override
    public void deactivateController() {
        suspend();
    }

    @Override
    public void activateController(MainView mainView) {
        if (viewIsNull(view)) {
            setView(mainView);
            this.mainView = mainView;
        }
        try {
            attachView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resume();

    }

    protected void setView(MainView mainView) {
        if (viewIsNull(view)) {
            view = mainView.getRegionCarriableView();
        }
    }

    protected boolean viewIsNull(JPanel view) {
        return view == null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        setIndex( getCarriableIndex(e));
        setCurrentRegion(cursorState.getActiveRegion());
        //TODO: match index with the right currentCarriable
        carriableClick();
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

    /**
     * gets the current currentCarriable index inside of the iterator
     *
     * @param e
     * @return
     */
    private int getCarriableIndex(MouseEvent e) {
        PixelPoint point = new PixelPoint(e.getX(), e.getY());
        int index = view.getCarriableIndex(point);
        System.out.println(index);
        return index;
    }

    public Carriable getCurrentCarriable() {
        return currentCarriable;
    }

    private void setCarrIt(CarriableIterator carrIt) {
        this.carrIt = carrIt;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    private void setCurrentRegion(Region currentRegion){
        this.currentRegion = currentRegion;
    }

    protected int getCurrentIndex(){
        return index;
    }


    public void assignCarriables(CarriableIterator carrIt) {
        setCarrIt(carrIt);
        displayCarriables();
    }

    protected void displayCarriables() {
        if (carrIt != null) {
            //TODO: function to add carriables to  view
        }
        showPanel();
    }

    protected void showPanel() {
        view.setVisible(true);
    }

    protected void hidePanel() {
        view.setVisible(false);
    }

    protected RegionCarriableView getView() {
        return view;
    }

    protected Region getCurrentRegion(){
        return currentRegion;
    }

    protected void removeCarriable() {
        carrIt.deleteAt(index);
    }

}
