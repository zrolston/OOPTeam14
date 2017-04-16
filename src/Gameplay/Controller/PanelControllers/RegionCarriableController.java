package Gameplay.Controller.PanelControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Views.MainView.MainView;
import Gameplay.Views.MainView.RegionCarriableView;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jordi on 4/15/2017.
 */
public abstract class RegionCarriableController implements MainViewController,MouseListener{
    private MainView mainView;
    private RegionCarriableView view;
    private Carriable currentCarriable;

    protected abstract void attachView(JPanel view) throws Exception;
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
            this.mainView=mainView;
        }
        try {
            attachView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resume();
    }

    protected void setView(MainView mainView){
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
      int index = getCarriableIndex(e);
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
     * @param e
     * @return
     */
    private int getCarriableIndex(MouseEvent e){
        PixelPoint point = new PixelPoint(e.getX(), e.getY());
        int index = view.getCarriableIndex(point);
        System.out.println(index);
        return index;
    }

    public Carriable getCurrentCarriable() {
        return currentCarriable;
    }

}
