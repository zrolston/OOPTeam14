package Gameplay.Controller.PanelControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Views.MainView.MainView;
import Gameplay.Views.MainView.TransporterCarriableView;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Created by jordi on 4/15/2017.
 */
public abstract class TransporterCarriableController implements MainViewController, MouseListener {
    TransporterCarriableView view;
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();
    Carriable carriable;
    MainView mainView;


    private TransporterCarriableView getView(MainView mainView) {
        if (viewIsNull(view)) {
            view = mainView.getTransporterCarriableView();
            this.mainView = mainView;
        }
        return view;
    }

    @Override
    public void activateController(MainView mainView) {

        if (viewIsNull(view)) {
            view = getView(mainView);
        }
        try {
            attachView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resume();
    }

    private boolean viewIsNull(JPanel view) {
        return view == null;
    }

    private void attachView(JPanel view) throws Exception {

        if (viewIsNull(view)) {
            throw new Exception("The view that was tried to be attached was null");
        }
        view.addMouseListener(this);
    }

    protected abstract void resume();

    @Override
    public void mousePressed(MouseEvent e) {
        PixelPoint point = new PixelPoint(e.getX(), e.getY());
        int index = view.getCarriableIndex(point);
        System.out.println(index);

    }


    private void determineClick(int index){
        if (index>7){
            setCurrentCarriable(index%8);
            carriableClick();
        }
        else{
            //TODO:set transporters
            transporterClick();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

    public void addTransporters(List<Transporter> transporters){
        addToLeftColumn(transporters);
        view.setVisible(true);
    }

    private void addCarriables(Region region){
        //TODO: gameModelFacade.getCarriables(region)
        //TODO: addToRightColumn
    }

    private void addToLeftColumn(List<Transporter> transporters){
        //TODO: add transporters to left column in the view
    }
    protected void addToRightColumn(Carriable carriable){
        //TODO: add carriable to the right column
    }

    protected void transporterClick(){
        //todo: get goods associated with the transporter
        //TODO: addRightColumn();
    }

    protected abstract void carriableClick();

    public void hidePanel(){
        view.setVisible(false);
    }

    protected void setCurrentCarriable(int number){
        //TODO:iterator.getCarriable(number);
    }

    protected Carriable getCurrentCarriable(){
        return carriable;
    }

    public MainView getMainView() {
        return mainView;
    }

    /**
     * to empty the whole controller and view
     */
    public void emptyPanel(){

    }

    protected void clearCurrentCarriable(){
        carriable = null;
    }
}
