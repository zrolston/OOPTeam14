package Gameplay.Controller.SubControllers.RegionCarriableControllers;

import Gameplay.Controller.PanelControllers.RegionCarriableController;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;

import javax.swing.*;

/**
 * Created by jordi on 4/16/2017.
 */
public class PickUpController extends RegionCarriableController {

    Transporter transporter;

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
        if (transporter != null) {
            gmf.pickUpCarriable(getCurrentRegion(), getTransporter(), getCurrentCarriable());
            removeCarriable();
        }
    }

    public void receiveTransporter(Transporter transporter) {
        this.transporter = transporter;
        showPanel();
    }

    private Transporter getTransporter() {
        return transporter;
    }
}
