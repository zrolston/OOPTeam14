package Gameplay.Controller.SubControllers.RegionCarriableControllers;

import Gameplay.Controller.PanelControllers.RegionCarriableController;
import Gameplay.Model.Transporters.Transporter;

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
        if (transporter != null) {
            //TODO: facade.pickupCarriable(transporter, getCurrentCarriable);
            //TODO: delete at the place the carriable is at
        }
    }

    public void receiveTransporter(Transporter transporter){
        this.transporter = transporter;
        showPanel();
    }
}
