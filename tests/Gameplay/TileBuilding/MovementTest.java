package Gameplay.TileBuilding;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.TransporterFactory.DonkeyFactory;
import Gameplay.Model.TransporterFactory.RowboatFactory;
import Gameplay.Model.TransporterFactory.TransporterFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameMapDaveBuilder;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.MapParsers.DaveBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class MovementTest {
    TransporterFactory donkeyFactory = new DonkeyFactory();
    TransporterFactory rowboatFactory = new RowboatFactory();
    private GameMap map;

    @Before
    public void init(){
        DaveBuilder builder = new GameMapDaveBuilder();
        builder.buildMap("C:\\Users\\Cameron\\IdeaProjects\\OOPTeam14\\res\\SavedMaps\\mapTest.dave");
        GameModelFacade facade = GameModelFacade.getInstance();
        this.map = facade.getMap();
    }

    @Test
    public void testDonkeyMovement() throws Exception {
        GameTile tile = map.getTileAt(new HexLocation(10,10));
        RegionMap regionMap = tile.getRegionMap();

        HexaVertex v = HexaVertex.createVertex(2);
        Region region = regionMap.getRegionAt(v);

        Transporter donkey = donkeyFactory.create();

        region.enterRegion(donkey);

        Map<Region, Integer> movementList = donkey.getMovementList();
        assertEquals(movementList.size(), 2);

        for (Region r : movementList.keySet()) {
            assertEquals(r.getClass(), LandRegion.class);
        }

        //Simulate Movement

        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        Set<Region> visitedList = new HashSet<>();
        int repetitions = 5;
        while (repetitions > 0){
            int size = movementList.size();
            int randomRegion = rand.nextInt(size); // 0 <= randomRegion < size
            Region nextRegion = null;
            for (Region r : movementList.keySet()) {
                if (randomRegion > 0){
                    randomRegion--;
                    continue;
                }
                nextRegion = r;
                break;
            }
            if(repetitions > 4){
                assertEquals(donkey.moveTo(nextRegion), true);
            }
            else{
                assertEquals(donkey.moveTo(nextRegion), false);
            }
            assertEquals(nextRegion.getClass(), LandRegion.class);
            visitedList.add(nextRegion);
            repetitions--;
        }
        System.out.println("Size of visited list: " + visitedList.size());
        assertTrue(visitedList.size() < 5 && visitedList.size() > 1);

    }

    @Test
    public void testBoatMovement() throws Exception{
        GameTile tile = map.getTileAt(new HexLocation(11,10));
        RegionMap regionMap = tile.getRegionMap();

        HexaVertex v = HexaVertex.createVertex(2);
        Region region = regionMap.getRegionAt(v);

        Transporter boat = rowboatFactory.create();

        region.enterRegion(boat);

        Map<Region, Integer> movementList = boat.getMovementList();
        assertEquals(movementList.size(), 5);

        //Simulate Movement

        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        Set<Region> visitedList = new HashSet<>();
        int repetitions = 5;
        while (repetitions > 0){
            int size = movementList.size();
            int randomRegion = rand.nextInt(size); // 0 <= randomRegion < size
            Region nextRegion = null;
            for (Region r : movementList.keySet()) {
                if (randomRegion > 0){
                    randomRegion--;
                    continue;
                }
                nextRegion = r;
                break;
            }
            boat.moveTo(nextRegion);
            visitedList.add(nextRegion);
            repetitions--;
        }
        System.out.println("Size of visited list: " + visitedList.size());
        assertEquals(visitedList.size(), 8);
    }
}


