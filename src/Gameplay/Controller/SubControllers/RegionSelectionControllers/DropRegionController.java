package Gameplay.Controller.SubControllers.RegionSelectionControllers;

import Gameplay.Controller.PanelControllers.MapSelectionControllers.RegionSelectionController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.DropController;
import Gameplay.Model.Visitors.Carriable;

/**
 * Created by jordi on 4/16/2017.
 */
public class DropRegionController extends RegionSelectionController  {

    private Carriable carriable;
    private DropController dropController;

    public DropRegionController(DropController dropController) {
        this.dropController = dropController;
    }

    @Override
    protected void rightClick() {

    }

    @Override
    protected void leftClick() {
        //Todo:get Region from view
        //TODO:gameModelFacade.dropCarriable(,carriable);
        dropController.changeToDefaultController();
    }

    @Override
    protected void resume() {

    }


    public void receiveCarriable(Carriable carriable) {
        this.carriable = carriable;
    }

}


