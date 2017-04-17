package Gameplay.Controller.SubControllers.RegionSelectionControllers;

import Gameplay.Controller.PanelControllers.MapSelectionControllers.RegionSelectionController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.DropController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.MoveController;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Visitors.Carriable;
import MapBuilder.Model.ModelFacade;

/**
 * Created by jordi on 4/16/2017.
 */
public class DropRegionController extends RegionSelectionController  {

    private DropController moveController;

    public DropRegionController(DropController moveController) {
        this.moveController = moveController;
    }

    @Override
    protected void rightClick() {
        moveController.changeToDefaultController();
    }

    @Override
    protected void leftClick() {
        moveController.dropCarriable(getCurrentRegion());
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


}


