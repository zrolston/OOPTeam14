package Gameplay.Controller.SubControllers.RegionCarriableControllers;

import Gameplay.Controller.PanelControllers.RegionCarriableController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.MoveController;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Visitors.Carriable;

import javax.swing.*;

/**
 * Created by jordi on 4/16/2017.
 */
public class PickUpController extends RegionCarriableController {

    private Transporter currentTransporter;
    private Region currentRegion;

    public PickUpController(MoveController moveController) {
        this.moveController = moveController;
    }

    MoveController moveController;

    @Override
    protected void attachView(JPanel view) throws Exception {
        getView().addMouseListener(this);
    }

    @Override
    protected void resume() {

    }

    @Override
    protected void suspend() {
        hidePanel();
    }

    @Override
    protected void carriableClick() {
        GameModelFacade gmf = GameModelFacade.getInstance();
        if (areContributorsNull( currentRegion, currentTransporter,getCurrentCarriable())) {
            gmf.pickUpCarriable(currentRegion, currentTransporter, getCurrentCarriable());
            removeCarriable();
        }
    }

    private boolean areContributorsNull(Region region, Transporter transporter, Carriable carriable) {
        return transporter != null && region != null && carriable != null;
    }

    public void receiveTransporter(Transporter transporter) {
        this.currentTransporter = transporter;
        showPanel();
    }

    public void receiveRegion(Region region) {
        this.currentRegion = region;
        displayPanel();
    }

    private void displayPanel(){
        //TODO: delete this
        getView().setVisible(true);
        if (getCarriableIterator()!= null && getCarriableIterator().size() >0) {
            getView().setVisible(true);
        }
    }

}
