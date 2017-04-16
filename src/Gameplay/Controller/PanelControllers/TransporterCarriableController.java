package Gameplay.Controller.PanelControllers;

import Gameplay.Controller.MainViewController;
import Gameplay.Model.Iterators.CarriableIterator;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Views.MainView.MainView;
import Gameplay.Views.MainView.TransporterCarriableView;
import Gameplay.Views.Utility.CursorState;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jordi on 4/15/2017.
 */
public abstract class TransporterCarriableController implements MainViewController, MouseListener {
    //views
    private TransporterCarriableView view;
    private MainView mainView;
    //access point to the model
    private GameModelFacade gameModelFacade = GameModelFacade.getInstance();
    //currents
    private Carriable currentCarriable;
    private Transporter currentTransporter;
    private int index = -1;
    //iterators
    private CarriableIterator carrIt;
    private TransporterIterator transIt;
    //buttons
    private final int buttonNumber = 8;
    private CursorState cursorState = CursorState.getInstance();


    protected abstract void resume();

    //    protected abstract void suspend();
    protected abstract void carriableClick();

    private TransporterCarriableView getView(MainView mainView) {
        if (viewIsNull(view)) {
            view = mainView.getTransporterCarriableView();
            this.mainView = mainView;
        }
        return view;
    }

    @Override
    public void deactivateController() {
//        suspend();
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

    @Override
    public void mousePressed(MouseEvent e) {
        PixelPoint point = new PixelPoint(e.getX(), e.getY());
        setIndex(view.getCarriableIndex(point));
        System.out.println(index);

        if (!isOutOfBounds(index)) {
            determineClick(index);
        }

    }

    private boolean isOutOfBounds(int index) {
        return index <= -1;
    }

    private void determineClick(int index) {
        if (index > buttonNumber - 1) {
            setCurrentCarriable(index % buttonNumber);
            carriableClick();
            removeCarriable();//implemented now it might change
        } else {
            setCurrentTransporter(index);
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

    public void addTransporters(TransporterIterator transporters) {
        addToPanelLeftColumn(transporters);
        setTransIt(transporters);
        view.setVisible(true);
    }

    /**
     * add transporters to left column in the view
     *
     * @param transporters
     */
    private void addToPanelLeftColumn(TransporterIterator transporters) {
        if (transporters != null) {
            //TODO: add transporters to left column in the view
        }
    }

    /**
     * add carriables to the right column of the view
     *
     * @param carriables
     */
    protected void addToPanelRightColumn(CarriableIterator carriables) {
        if (carriables != null) {
            //TODO: add currentCarriable to the right column
        }
    }

    /**
     * gets the carriables associated with the transporter, and sets them in carrIt
     * adds the goods to the right column
     * when a transporter is clicked
     */
    protected void transporterClick() {
        setCarrItFromFacade();
        addToPanelRightColumn(carrIt);
        //TODO: beware of overriding the function of a subclass
    }

    /**
     * hides the panel to which the controller is attached to
     */
    public void hidePanel() {
        view.setVisible(false);
    }

    protected void showPanel() {
        view.setVisible(true);
    }

    protected void setCurrentCarriable(int number) {
        if (carrIt != null) {
            currentCarriable = carrIt.getCarriableAt(number);
        }
    }

    protected void setCurrentTransporter(int number) {
        if (transIt != null) {
            currentCarriable = transIt.getTransporterAt(number);
        }
    }

    protected void setCarrIt(CarriableIterator carrIt) {
        this.carrIt = carrIt;
    }

    protected void setTransIt(TransporterIterator transIt) {
        this.transIt = transIt;
    }

    /**
     * gets the carriable iterator from the current transporter
     * sets it to the global carrIt
     */
    protected void setCarrItFromFacade() {
        if (!isCurrentTransporterNull()) {
            CarriableIterator car = gameModelFacade.getTransporterCarriable(currentTransporter);
            setCarrIt(car);
        }
    }

    public void setIndex(int index) {
        this.index = index;
    }

    protected Carriable getCurrentCarriable() {
        return currentCarriable;
    }

    protected Transporter getCurrentTransporter() {
        return currentTransporter;
    }

    protected TransporterIterator getTransporterIterator() {
        return transIt;
    }

    public MainView getMainView() {
        return mainView;
    }

    /**
     * to empty the whole controller and view
     */
    public void emptyPanel() {
        //TODO: Implement function
    }

    protected void clearCurrentCarriable() {
        currentCarriable = null;
    }

    protected void clearCurrentTransporter() {
        currentTransporter = null;
    }

    private boolean isCurrentTransporterNull() {
        return currentTransporter == null;
    }

    protected void removeCarriable() {
        carrIt.deleteAt(index);
    }
}
