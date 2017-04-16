package Gameplay.Model.Utility;

import Gameplay.Model.Map.GameMap;
import MapBuilder.Model.Utility.MapParsers.DaveBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zrgam_000 on 4/14/2017.
 */
public class MapGeneratorTest {

    MapGenerator gen;
    List<GameTilePlacement> gameTilePlacements;

    @Before
    public void TestSetup(){
        
    }

    @Test
    public void generateRegionSets() {
        DaveBuilder _builder = new GameMapDaveBuilder();
        _builder.buildMap("C:\\Users\\Cameron\\IdeaProjects\\OOPTeam14\\res\\SavedMaps\\mapTest.dave");
        GameModelFacade facade = GameModelFacade.getInstance();
        GameMap map = facade.debugGetMap();
    }

}