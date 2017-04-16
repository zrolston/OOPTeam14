package Gameplay.Controller.SubControllers.RegionSelectionControllers;

import Gameplay.Controller.PanelControllers.MapSelectionControllers.RegionSelectionController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.DropController;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.Utility.CursorState;

import java.util.List;

/**
 * Created by jordi on 4/16/2017.
 */
public class MoveRegionController extends RegionSelectionController {

    private boolean movement = false;
    //TODO: Transporter iterator
    private DropController dropController;
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();

    public MoveRegionController(DropController dropController) {
        this.dropController = dropController;
    }

    /**
     * allows movement
     */
    @Override
    protected void rightClick() {

        if (movement) {
            //TODO: getRegion from view
            //gameModelFacade.move(//region that was gotten);
            disallowMovement();
            emptyDropController();
        }
    }

    /**
     * allows for selection
     */
    @Override
    protected void leftClick() {

        //Todo: selectRegion, get transporters and add it to the controller
        //todo: dropController.addTransporters(region that was selected)
        emptyDropController();
    }

    @Override
    protected void resume() {
    }

    @Override
    protected void suspend() {
        getMapView().removeMouseListener(this);
    }


    private TransporterIterator addTransporters(Region region) {
        gameModelFacade.getTransporters(region);
        //TODO: gameModelFacade.getTransporters()
        //TODO: dropController.addTransporters();
        return null;
    }

    public void allowMovement() {
        movement = true;
    }

    public void disallowMovement() {
        movement = false;
    }

    private void emptyDropController(){
        dropController.emptyPanel();
        dropController.checkForDisplay();
    }

}