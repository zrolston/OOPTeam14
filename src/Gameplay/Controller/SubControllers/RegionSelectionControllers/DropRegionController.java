package Gameplay.Controller.SubControllers.RegionSelectionControllers;

import Gameplay.Controller.PanelControllers.MapSelectionControllers.RegionSelectionController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.MoveController;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.Carriable;
import MapBuilder.Model.ModelFacade;

/**
 * Created by jordi on 4/16/2017.
 */
public class DropRegionController extends RegionSelectionController  {

    private MoveController moveController;
    private Region currentRegion;
    private Transporter currentTransporter;
    private Carriable currentCarriable;
    private ModelFacade modelFacade = ModelFacade.getInstance();

    public DropRegionController(MoveController moveController) {
        this.moveController = moveController;
    }

    @Override
    protected void rightClick() {
        moveController.changeToDefaultController();
    }

    @Override
    protected void leftClick() {
        moveController.dropCarriable(currentRegion);
        moveController.changeToDefaultController();
        suspend();
    }

    @Override
    protected void resume() {

    }

    @Override
    protected void suspend() {
        getMapView().removeMouseListener(this);
    }

    public void receiveCarriable(Carriable carriable) {
        this.currentCarriable = carriable;
    }
    public void receiveTransporter(Transporter transporter) {
        this.currentTransporter = transporter;
    }


}


