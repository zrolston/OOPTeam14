package Gameplay.Model.Utility;

import Gameplay.Model.Map.GameMap;
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
        gen = new MapGenerator();
    }

    @Test
    public void generateRegionSets() {
        GameMap map = new GameMap(21, 21);
        GameModelFacade.initialize(map);
        GameModelFacade facade = GameModelFacade.getInstance();
        facade.loadMap("C:\\Users\\Cameron\\IdeaProjects\\OOPTeam14\\res\\SavedMaps\\full board map.dave");
        map = facade.debugGetMap();
    }

}