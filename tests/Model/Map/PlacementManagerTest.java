package Model.Map;

import Model.Tile.BuildTile;
import Model.Tile.BuildTileFactory;
import Model.Utility.HexLocation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zrgam_000 on 3/27/2017.
 */
public class PlacementManagerTest {

    PlacementManager placementManager;
    BuildMap buildMap;
    BuildTileFactory btf;

    @Before
    public void TestSetup(){
        BuildMap.reset();
        buildMap = BuildMap.getInstance();
        placementManager = new PlacementManager();
        btf = new BuildTileFactory();
    }

    @Test
    public void validate() {
        BuildMap.reset();
        buildMap = BuildMap.getInstance();
        placementManager = new PlacementManager();

        BuildTile tile = btf.createTile("ROCK",  new int[]{1, 4});
        placementManager.placeTileAt(tile, new HexLocation(5, 5));
        tile = btf.createTile("SEA",  new int[]{});
        placementManager.placeTileAt(tile, new HexLocation(4, 5));
        tile = btf.createTile("WOODS",  new int[]{});
        placementManager.placeTileAt(tile, new HexLocation(6, 4));

        BuildTile LandTile = btf.createTile("DESERT",  new int[]{});
        BuildTile SeaTile = btf.createTile("SEA",  new int[]{});
        BuildTile RiverTile = btf.createTile("MOUNTAIN",  new int[]{1, 3});

        assertTrue(placementManager.validate(LandTile, new HexLocation(3, 5)));
        assertTrue(placementManager.validate(LandTile, new HexLocation(4, 6)));
        assertTrue(placementManager.validate(LandTile, new HexLocation(5, 6)));
        assertTrue(placementManager.validate(LandTile, new HexLocation(6, 6)));
        assertFalse(placementManager.validate(LandTile, new HexLocation(6, 5)));
        assertTrue(placementManager.validate(LandTile, new HexLocation(7, 4)));
        assertTrue(placementManager.validate(LandTile, new HexLocation(6, 3)));
        assertTrue(placementManager.validate(LandTile, new HexLocation(5, 3)));
        assertTrue(placementManager.validate(LandTile, new HexLocation(5, 4)));
        assertTrue(placementManager.validate(LandTile, new HexLocation(4, 4)));

        assertTrue(placementManager.validate(SeaTile, new HexLocation(3, 5)));
        assertTrue(placementManager.validate(SeaTile, new HexLocation(4, 6)));
        assertTrue(placementManager.validate(SeaTile, new HexLocation(5, 6)));
        assertTrue(placementManager.validate(SeaTile, new HexLocation(6, 6)));
        assertTrue(placementManager.validate(SeaTile, new HexLocation(6, 5)));
        assertTrue(placementManager.validate(SeaTile, new HexLocation(7, 4)));
        assertTrue(placementManager.validate(SeaTile, new HexLocation(6, 3)));
        assertTrue(placementManager.validate(SeaTile, new HexLocation(5, 3)));
        assertTrue(placementManager.validate(SeaTile, new HexLocation(5, 4)));
        assertTrue(placementManager.validate(SeaTile, new HexLocation(4, 4)));

        assertTrue(placementManager.validate(RiverTile, new HexLocation(3, 5)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(4, 6)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(5, 6)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(6, 6)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(6, 5)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(7, 4)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(6, 3)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(5, 3)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(5, 4)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(4, 4)));

        RiverTile = btf.createTile("MOUNTAIN",  new int[]{3, 4});

        assertTrue(placementManager.validate(RiverTile, new HexLocation(3, 5)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(4, 6)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(5, 6)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(6, 6)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(6, 5)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(7, 4)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(6, 3)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(5, 3)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(5, 4)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(4, 4)));

        RiverTile = btf.createTile("MOUNTAIN",  new int[]{1, 3, 5});

        assertTrue(placementManager.validate(RiverTile, new HexLocation(3, 5)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(4, 6)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(5, 6)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(6, 6)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(6, 5)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(7, 4)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(6, 3)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(5, 3)));
        assertFalse(placementManager.validate(RiverTile, new HexLocation(5, 4)));
        assertTrue(placementManager.validate(RiverTile, new HexLocation(4, 4)));

        placementManager.removeTileAt(new HexLocation(5,5));

        tile = btf.createTile("ROCK",  new int[]{1, 4});

        assertFalse(placementManager.validate(RiverTile, new HexLocation(5, 5)));
        assertTrue(placementManager.validate(tile, new HexLocation(5, 5)));
    }

    @Test
    public void placeTileAt() {
        BuildMap.reset();
        buildMap = BuildMap.getInstance();
        placementManager = new PlacementManager();

        BuildTile tile = btf.createTile("ROCK",  new int[]{1, 4});

        assertEquals(0,placementManager.getNumSlots());

        placementManager.placeTileAt(tile, new HexLocation(5, 5));

        assertEquals(6,placementManager.getNumSlots());

        tile = btf.createTile("SEA",  new int[]{});

        placementManager.placeTileAt(tile, new HexLocation(4, 5));

        assertEquals(8,placementManager.getNumSlots());

        tile = btf.createTile("WOODS",  new int[]{});

        placementManager.placeTileAt(tile, new HexLocation(6, 4));

        assertEquals(10, placementManager.getNumSlots());
    }

    @Test
    public void removeTileAt() {
        BuildMap.reset();
        buildMap = BuildMap.getInstance();
        placementManager = new PlacementManager();

        BuildTile tile = btf.createTile("ROCK",  new int[]{1, 4});

        assertEquals(0,placementManager.getNumSlots());

        placementManager.placeTileAt(tile, new HexLocation(5, 5));

        assertEquals(6,placementManager.getNumSlots());

        tile = btf.createTile("SEA",  new int[]{});

        placementManager.placeTileAt(tile, new HexLocation(4, 5));

        assertEquals(8,placementManager.getNumSlots());

        tile = btf.createTile("WOODS",  new int[]{});

        placementManager.placeTileAt(tile, new HexLocation(6, 4));

        assertEquals(10,placementManager.getNumSlots());

        placementManager.removeTileAt(new HexLocation(5, 5));

        assertEquals(10,placementManager.getNumSlots());

        tile = btf.createTile("SEA",  new int[]{});

        placementManager.removeTileAt(new HexLocation(4, 5));

        assertEquals(6,placementManager.getNumSlots());

        tile = btf.createTile("WOODS",  new int[]{});

        placementManager.removeTileAt(new HexLocation(6, 4));

        assertEquals(0, placementManager.getNumSlots());
    }

    @Test
    public void validateRivers(){
        BuildMap.reset();
        buildMap = BuildMap.getInstance();
        placementManager = new PlacementManager();

        BuildTile tile = btf.createTile("ROCK",  new int[]{1, 4});
        placementManager.placeTileAt(tile, new HexLocation(5, 5));
        tile = btf.createTile("SEA",  new int[]{});
        placementManager.placeTileAt(tile, new HexLocation(4, 5));
        tile = btf.createTile("WOODS",  new int[]{});
        placementManager.placeTileAt(tile, new HexLocation(6, 4));

        BuildTile RiverTile = btf.createTile("MOUNTAIN",  new int[]{1});

        assertFalse(placementManager.validateRivers());

        placementManager.placeTileAt(RiverTile, new HexLocation(6, 5));

        assertTrue(placementManager.validateRivers());

        placementManager.removeTileAt(new HexLocation(5, 5));

        assertFalse(placementManager.validateRivers());

        tile = btf.createTile("ROCK",  new int[]{1, 4});
        placementManager.placeTileAt(tile, new HexLocation(5, 5));

        assertTrue(placementManager.validateRivers());

        placementManager.removeTileAt(new HexLocation(4, 5));

        assertFalse(placementManager.validateRivers());
    }

}