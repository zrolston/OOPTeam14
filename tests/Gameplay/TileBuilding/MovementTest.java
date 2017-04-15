package Gameplay.TileBuilding;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.TransporterFactory.DonkeyFactory;
import Gameplay.Model.TransporterFactory.TransporterFactory;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import MapBuilder.Model.Utility.HexLocation;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class MovementTest {
    TransporterFactory factory = new DonkeyFactory();

    @Test
    public void testMapBuilding() throws Exception {
        GameMap map = new GameMap(21, 21);
        GameModelFacade.initialize(map);
        GameModelFacade facade = GameModelFacade.getInstance();
        facade.loadMap("C:\\Users\\Cameron\\IdeaProjects\\OOPTeam14\\res\\SavedMaps\\mapTest.dave");
        map = facade.debugGetMap();

        GameTile tile = map.getTileAt(new HexLocation(10,10));
        RegionMap regionMap = tile.getRegionMap();

        HexaVertex v = HexaVertex.createVertex(2);
        Region region = regionMap.getRegionAt(v);

        Transporter donkey = factory.create();

        region.enterRegion(donkey);

        List<Region> movementList = donkey.getMovementList();
        assertNotEquals(movementList.size(), 0);

        for (Region r : movementList) {
            assertEquals(r.getClass(), LandRegion.class);
        }

        //Simulate Movement

        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        Set<Region> visitedList = new HashSet<>();
        int repetitions = 20;
        while (repetitions > 0){
            int size = movementList.size();
            int randomRegion = rand.nextInt(size); // 0 <= randomRegion < size
            Region nextRegion = movementList.get(randomRegion);
            nextRegion.enterRegion(donkey);
            visitedList.add(nextRegion);
            repetitions--;
        }
        System.out.println("Size of visited list: " + visitedList.size());

    }
}


