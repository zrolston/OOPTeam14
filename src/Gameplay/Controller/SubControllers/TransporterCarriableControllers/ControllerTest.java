package Gameplay.Controller.SubControllers.TransporterCarriableControllers;

import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Utility.GameMapDaveBuilder;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Views.Display;
import Gameplay.Views.Utility.CursorState;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.MapParsers.BuildMapDaveBuilder;
import MapBuilder.Model.Utility.MapParsers.DaveBuilder;


/**
 * Created by jordi on 4/16/2017.
 */
public class ControllerTest {


    public static void main(String[] args) {
        Display display = new Display();
        DaveBuilder builder = new GameMapDaveBuilder();
        builder.buildMap("/Users/Thomas/Desktop/OOPTeam14/res/SavedMaps/full board map.dave");
        GameModelFacade modelFacade =  GameModelFacade.getInstance();
        MoveController moveController = new MoveController();
        moveController.activateController(display.getMainView());

        modelFacade.startGame();
//        moveController.addTransporters(generateCarriableIter(modelFacade));

    }


    public static TransporterIterator generateCarriableIter(GameModelFacade modelFacade) {

        System.out.println("gen car iter");


        if(modelFacade == null)
            return null;

        GameMap map = modelFacade.debugGetMap();

        HexLocation loc = CursorState.getInstance().getActiveTile();

        GameTile tile = map.getTileAt( loc );

        System.out.println(tile);

        RegionMap rm = tile.getRegionMap();

        Region r = rm.getRegionAt( new HexaVertex(2, -1) );

        System.out.println(r);
        System.out.println("iter size" +  modelFacade.getTransporters(r).size());
        return modelFacade.getTransporters(r);
    }



}