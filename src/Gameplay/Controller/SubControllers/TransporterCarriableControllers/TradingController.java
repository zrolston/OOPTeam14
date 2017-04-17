package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.DropRegionController;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.GameModelFacade;

/**
 * Created by jordi on 4/17/2017.
 */
public class TradingController extends TransporterCarriableController implements DropController {
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();

    private DropRegionController dropRegionController = new DropRegionController(this);
    @Override
    public void dropCarriable(Region region) {
        //TODO: maybe add a check
        gameModelFacade.dropCarriable(region, getCurrentTransporter(),getCurrentCarriable());
        removeCarriable();

        TransporterIterator trans = gameModelFacade.getTransporters(region);
        addTransporters(trans);

        activateDropRegionController();
    }

    @Override
    public void changeToDefaultController() {

    }

    @Override
    protected void resume() {
        dropRegionController.activateController(getMainView());
    }

    @Override
    protected void carriableClick() {
        activateDropRegionController();
    }

    @Override
    protected void transporterClick() {

    }

    private void activateDropRegionController(){
        dropRegionController.activateController(getMainView());
    }

}
