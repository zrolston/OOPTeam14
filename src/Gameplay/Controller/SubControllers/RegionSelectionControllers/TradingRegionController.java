package Gameplay.Controller.SubControllers.RegionSelectionControllers;

import Gameplay.Controller.PanelControllers.MapSelectionControllers.RegionSelectionController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.TradingController;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.GameModelFacade;

/**
 * Created by jordi on 4/17/2017.
 */
public class TradingRegionController extends RegionSelectionController{

    TradingController tradingController;
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();



    public TradingRegionController(TradingController tradingController) {
        this.tradingController = tradingController;
    }

    @Override
    protected void resume() {

    }

    @Override
    protected void suspend() {
        getMapView().removeMouseListener(this);
    }

    @Override
    protected void rightClick() {

    }

    @Override
    protected void leftClick() {
        addTransporters(getCurrentRegion());
        tradingController.setRegion(getCurrentRegion());
        suspend();

    }


    private void addTransporters(Region region) {
        TransporterIterator tr = getTransporters(region);
        tradingController.addTransporters(tr);
    }

    private TransporterIterator getTransporters(Region region){
        return gameModelFacade.getTransporters(region);
    }
}
