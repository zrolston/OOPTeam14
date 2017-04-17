package Gameplay.Controller.SubControllers.RegionSelectionControllers;

import Gameplay.Controller.PanelControllers.MapSelectionControllers.RegionSelectionController;
import Gameplay.Controller.SubControllers.TransporterCarriableControllers.MoveController;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;

/**
 * Created by jordi on 4/16/2017.
 */
public class MoveRegionController extends RegionSelectionController {

    private boolean movement = false;
    private MoveController moveController;
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();
    Transporter currentTransporter;

    public MoveRegionController(MoveController moveController) {
        this.moveController = moveController;
    }

    /**
     * allows movement
     */
    @Override
    protected void rightClick() {

        if (movement) {

            if (currentTransporter != null) {
                gameModelFacade.move(currentTransporter, currentTransporter.getCurrentRegion());

            }
            disallowMovement();
            emptyDropController();
        }
    }

    /**
     * allows for selection
     */
    @Override
    protected void leftClick() {
        addTransporters(getCurrentRegion());
        moveController.setRegion(getCurrentRegion());
        //TODO: UNCOMENT THIISSSSSSS!!!!!!!!!!!!!!!!!!!!!!
//        moveController.checkForDisplay();
    }

    @Override
    protected void resume() {
    }

    @Override
    protected void suspend() {
        getMapView().removeMouseListener(this);
    }


    private void addTransporters(Region region) {
        TransporterIterator tr = getTransporters(region);
        moveController.addTransporters(tr);
    }

    public void allowMovement() {
        movement = true;
    }

    public void disallowMovement() {
        movement = false;
    }

    public void receiveTransporter(Transporter transporter){
        this.currentTransporter = transporter;
    }

    private void emptyDropController(){
        //moveController.emptyPanel();
        moveController.addTransporters(gameModelFacade.getTransporters(getCurrentRegion()));
        //TODO: UNCOMENT THIISSSSSSS!!!!!!!!!!!!!!!!!!!!!!
//     moveController.checkForDisplay();
    }
    private TransporterIterator getTransporters(Region region){
        return gameModelFacade.getTransporters(region);
    }
}