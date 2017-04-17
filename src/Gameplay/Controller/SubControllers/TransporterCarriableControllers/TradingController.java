package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.DropRegionController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.TradingRegionController;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.GameModelFacade;

/**
 * Created by jordi on 4/17/2017.
 */
public class TradingController extends TransporterCarriableController implements DropController {
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();

    private DropRegionController dropRegionController = new DropRegionController(this);
    private TradingRegionController tradingRegionController = new TradingRegionController(this);
    Region selectedRegion;


    @Override
    public void dropCarriable(Region region) {
        //TODO: maybe add a check
        gameModelFacade.dropCarriable(region, getCurrentTransporter(),getCurrentCarriable());
        removeCarriable();

        TransporterIterator trans = gameModelFacade.getTransporters(region);
        addTransporters(trans);

    }

    @Override
    public void changeToDefaultController() {
        tradingRegionController.activateController(getMainView());
    }

    @Override
    protected void resume() {
        tradingRegionController.activateController(getMainView());
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


    public void setRegion(Region region){
        selectedRegion = region;
    }


}
