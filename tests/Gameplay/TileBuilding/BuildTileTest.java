package Gameplay.TileBuilding;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Tile.GameTileBuilder;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Utility.GameModelFacade;
import org.junit.Test;

import java.util.ArrayList;

public class BuildTileTest {
    private GameTile gameTile;
    private GameTileBuilder tileBuilder;

    @Test
    public void testBasicTileCreation(){
        ArrayList<Integer> riverList = new ArrayList<>();
        riverList.add(1);
        riverList.add(3);
        tileBuilder = new GameTileBuilder();
        gameTile = tileBuilder.createTile("ROCK", riverList);
    }

    @Test
    public void testMapBuilding(){
        GameMap map = new GameMap(21, 21);
        GameModelFacade.initialize( );
        GameModelFacade facade = GameModelFacade.getInstance();
        facade.loadMap("C:\\Users\\Cameron\\IdeaProjects\\OOPTeam14\\res\\SavedMaps\\mapTest.dave");
        map = facade.debugGetMap();
    }
}
