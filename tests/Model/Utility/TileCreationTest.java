package Model.Utility;

import Model.Edge.Edge;
import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.*;
import Model.Tile.BuildTile;
import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

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

    @Test
    public void testPlainEdges(){
        BuildTileFactory factory = new BuildTileFactory();
        BuildTile seaTile = factory.createTile("SEA", new int[]{});
        Map<Integer, Edge> edgeMap = new HashMap<>(seaTile.getEdges());
        assertEquals(edgeMap.size(), 6);
        for (int i = 0; i < 6; i++){
            assertEquals(edgeMap.get(i).getClass(), (new SeaEdge()).getClass());
        }

        BuildTile landTile = factory.createTile("ROCK", new int[]{});
        edgeMap = new HashMap<>(landTile.getEdges());
        assertEquals(edgeMap.size(), 6);
        for (int i = 0; i < 6; i++){
            assertEquals(edgeMap.get(i).getClass(), (new LandEdge()).getClass());
        }
    }

    @Test
    public void testRiverEdges(){
        BuildTileFactory factory = new BuildTileFactory();
        BuildTile riverTile = factory.createTile("ROCK", new int[]{0, 3});
        Map<Integer, Edge> edgeMap = new HashMap<>(riverTile.getEdges());
        assertEquals(edgeMap.size(), 6);
        for (int i = 0; i < 6; i++){
            if (i == 0 || i == 3){
                assertEquals(edgeMap.get(i).getClass(), (new RiverEdge()).getClass());
            }
            else{
                assertEquals(edgeMap.get(i).getClass(), (new LandEdge()).getClass());
            }
        }
    }

}
