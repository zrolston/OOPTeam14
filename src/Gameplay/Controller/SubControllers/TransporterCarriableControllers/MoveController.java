package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.SubControllers.RegionCarriableControllers.PickUpController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.DropRegionController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.MoveRegionController;
import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;

import Gameplay.Model.Iterators.CarriableIterator;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Views.MainView.TransporterCarriableView;
import MapBuilder.Model.Utility.HexLocation;
import Gameplay.Views.Utility.CursorState;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by jordi on 4/16/2017.
 */
public class MoveController extends TransporterCarriableController implements DropController {

    private DropRegionController dropRegionController = new DropRegionController(this);
    private MoveRegionController moveRegionController = new MoveRegionController(this);
    private PickUpController pickUpController = new PickUpController(this);
    Region selectedRegion;
    GameModelFacade gameModelFacade = GameModelFacade.getInstance();
    public static Transporter currentTrans = null;

    @Override
    protected void carriableClick() {
        //TODO: view check if the region is a river, if it isn't drop it on the tile and gameModelFacade.canDropCarriable()
        activateDropRegionController();
        //TODO: UNCOMENT THIISSSSSSS!!!!!!!!!!!!!!!!!!!!!!
//        checkForDisplay();
    }

    @Override
    protected void transporterClick() {
        moveRegionController.allowMovement();
        sendCarriable();
        sendTransporter();
    }

    @Override
    protected void resume() {
        changeToDefaultController();
        clearCurrentCarriable();
        clearCurrentTransporter();

    }
    @Override
    public void changeToDefaultController() {
        checkForDisplay();
        moveRegionController.activateController(getMainView());
    }

    @Override
    public void sendCarriable() {
//        pickUpController.(getCurrentTransporter());
    }

    @Override
    public void sendTransporter() {
        currentTrans = getCurrentTransporter();
        moveRegionController.receiveTransporter(getCurrentTransporter());
    }

    public void checkForDisplay() {
        if ( getTransporterIterator()!= null && getTransporterIterator().size() == 0) {
            hidePanel();
            return;
        }
        showPanel();
    }

    @Override
    public void dropCarriable(Region region){
        gameModelFacade.dropCarriable(region, getCurrentTransporter(),getCurrentCarriable());
        removeCarriable();
        TransporterIterator trans = gameModelFacade.getTransporters(region);
        addTransporters(trans);
    }
    public Region getPickUpRegion(){
        return selectedRegion;
    }
    public void setRegion(Region region){
        selectedRegion = region;
        pickUpController.activateController(getMainView());
        pickUpController.receiveRegion(region);
    }

    private void activateDropRegionController(){
        dropRegionController.activateController(getMainView());
        dropRegionController.receiveCarriable(getCurrentCarriable());
        dropRegionController.receiveTransporter(getCurrentTransporter());
    }

    // --------



}

