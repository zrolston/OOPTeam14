package Model.Tile;

import Model.Edge.Edge;
import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.*;
import java.util.*;

public class BuildTileFactory {
    private int NUMEDGES = 6;
    public BuildTileFactory() {

    }

    public BuildTile createTile(String terrainType, int[] riverIndices) throws RuntimeException{
        Terrain t = getTerrain(terrainType);
        Map<Integer, Edge> edgeMap = new HashMap<>(NUMEDGES);

        List<Integer> list = new ArrayList<>();
        for (int riverIndex : riverIndices) {
            list.add(riverIndex);
        }

        if (terrainType.equals("SEA")){
            for (int i = 0; i < NUMEDGES; i++) {
                edgeMap.put(i, new SeaEdge());
            }
        }
        else{
            for (int i = 0; i < NUMEDGES; i++) {
                if(list.contains(i)){
                    edgeMap.put(i, new RiverEdge());
                }
                else{
                    edgeMap.put(i, new LandEdge());
                }
            }
        }
        return new BuildTile(t, edgeMap);
    }

    private Terrain getTerrain(String terrain){
        switch (terrain) {
            case "DESERT":
                return new DesertTerrain();
            case "MOUNTAIN":
                return new MountainTerrain();
            case "PASTURE":
                return new PastureTerrain();
            case "ROCK":
                return new RockTerrain();
            case "SEA":
                return new SeaTerrain();
            case "WOODS":
                return new WoodsTerrain();
            default: throw new RuntimeException("Invalid Terrain Type in constructor");
        }
    }
}
