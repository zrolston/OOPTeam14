package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Controller.PanelControllers.TransporterCarriableController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.DropRegionController;
import Gameplay.Controller.SubControllers.RegionSelectionControllers.MoveRegionController;
import Gameplay.Model.Goods.Goose;
import Gameplay.Model.Iterators.CarriableIterator;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.TransporterFactory.DonkeyFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Model.Visitors.Carriable;
import Gameplay.Views.Drawers.CarriableDrawingVisitor;
import Gameplay.Views.Drawers.TransporterDrawingVisitor;
import Gameplay.Views.MainView.MainView;
import Gameplay.Views.MainView.TransporterCarriableView;
import MapBuilder.Model.ModelFacade;
import MapBuilder.Model.Utility.HexLocation;
import Gameplay.Views.Utility.CursorState;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jordi on 4/16/2017.
 */
public class DropController extends TransporterCarriableController {

    private DropRegionController dropRegionController = new DropRegionController(this);
    private MoveRegionController moveRegionController = new MoveRegionController(this);


    private TransporterCarriableView view;
    private CarriableIterator carrIt;

    public DropController() {
//        changeToDefaultController();
//        hidePanel();
    }

    @Override
    protected void carriableClick() {
        //Todo:get the good and pass it to drop region controller
        //TODO: view check if the region is a river, if it isn't drop it on the tile
        dropRegionController.activateController(getMainView());
        dropRegionController.receiveCarriable(getCurrentCarriable());
        dropRegionController.receiveTransporter(getCurrentTransporter());
        hidePanel();
    }

    @Override
    protected void resume() {
        changeToDefaultController();
        clearCurrentCarriable();

    }

    @Override
    protected void transporterClick() {
        //todo: get goods associated with the transporter
        //TODO: addRightColumn();
        moveRegionController.allowMovement();
    }

    public void changeToDefaultController() {
        checkForDisplay();
        moveRegionController.activateController(getMainView());
    }

    public void checkForDisplay() {
        //TODO: if Trasnporter iterator is not empty
        //TODO: set view visible
        //TODO: if transporter iterator is empty
        //TODO: set view invisible
    }


    // --------

    public void generateCarriableIter() {

        GameModelFacade modelFacade =  GameModelFacade.getInstance();

        if(modelFacade == null)
            return;

         GameMap map = modelFacade.debugGetMap();


        HexLocation loc = CursorState.getInstance().getActiveTile();

        GameTile tile = map.getTileAt( loc );

        System.out.println(tile);


        RegionMap rm = tile.getRegionMap();



        Region r = rm.getRegionAt( new HexaVertex(2, -1) );

        System.out.println(r);

        carrIt = modelFacade.getRegionCarriable( r );
    }


    @Override
    public void attachView(TransporterCarriableView view){

        if (view == null) {
            return;
        }

        this.view = view;

        generateCarriableIter();
        view.setIter(carrIt);
        view.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {

        generateCarriableIter();

        PixelPoint point = new PixelPoint(e.getX(), e.getY());

        view.setIter( carrIt );
        ArrayList<Rectangle> buttons = view.getButtons();

        int index = 0; // get index of click
        for(Rectangle button: buttons){
            if(button.contains(point.getX(), point.getY())) {
                System.out.println(index);
                break;
            }
            index++;
        }

    }


}

