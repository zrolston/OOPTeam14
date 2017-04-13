package MapBuilder.Model.Utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import MapBuilder.Model.Terrain.DesertTerrain;
import MapBuilder.Model.Terrain.MountainTerrain;
import MapBuilder.Model.Terrain.PastureTerrain;
import MapBuilder.Model.Terrain.RockTerrain;
import MapBuilder.Model.Terrain.SeaTerrain;
import MapBuilder.Model.Terrain.Terrain;
import MapBuilder.Model.Terrain.WoodsTerrain;
import MapBuilder.Model.Tile.BuildTileFactory;
import MapBuilder.Model.Tile.Tile;

/**
 * Created by Cameron on 3/26/2017.
 */
public class TileCreationTest {
    private String[] terrains = {"DESERT", "ROCK", "MOUNTAIN", "PASTURE", "SEA", "WOODS"};
    private Terrain[] terrainArray = {new DesertTerrain(), new RockTerrain(), new MountainTerrain(),
                                        new PastureTerrain(), new SeaTerrain(), new WoodsTerrain()};
    @Test
    public void testTerrains(){
        BuildTileFactory factory = new BuildTileFactory();
        for (int i = 0; i < terrains.length; i++) {
            Tile tile = factory.createTile(terrains[i], new int[]{});
            assertEquals(tile.getTerrain().getClass(), terrainArray[i].getClass());
        }
    }

    @Test
    public void testInvalidTerrain(){
        BuildTileFactory factory = new BuildTileFactory();
        try {
            Tile tile = factory.createTile("BADTERRAIN", new int[]{});
            fail("Expected a RuntimeException to be thrown");
        } catch (RuntimeException aRuntimeException) {
            assertEquals(aRuntimeException.getMessage(), "Invalid Terrain Type in constructor");
        }
    }

/*    @Test
    public void testPlainEdges(){
        BuildTileFactory factory = new BuildTileFactory();
        BuildTile seaTile = factory.createTile("SEA", new int[]{});
        Map<HexaIndex, Edge> edgeMap = new HashMap<>(seaTile.getEdges());
        assertEquals(edgeMap.size(), 6);
        for (int i = 1; i < 7; i++){
            try {
                assertEquals(edgeMap.get(HexaIndex.createIndex(i)).getClass(), (new SeaEdge()).getClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        BuildTile landTile = factory.createTile("ROCK", new int[]{});
        edgeMap = new HashMap<>(landTile.getEdges());
        assertEquals(edgeMap.size(), 6);
        for (int i = 1; i < 7; i++){
            try {
                assertEquals(edgeMap.get(HexaIndex.createIndex(i)).getClass(), (new LandEdge()).getClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/

/*    @Test
    public void testRiverEdges(){
        BuildTileFactory factory = new BuildTileFactory();
        BuildTile riverTile = factory.createTile("ROCK", new int[]{1, 4});
        Map<HexaIndex, Edge> edgeMap = new HashMap<>(riverTile.getEdges());
        assertEquals(edgeMap.size(), 6);
        for (int i = 1; i < 7; i++){
            if (i == 1 || i == 4){
                try {
                    assertEquals(edgeMap.get(HexaIndex.createIndex(i)).getClass(), (new RiverEdge()).getClass());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    assertEquals(edgeMap.get(HexaIndex.createIndex(i)).getClass(), (new LandEdge()).getClass());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

}
