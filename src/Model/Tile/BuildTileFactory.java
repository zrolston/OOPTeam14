package Model.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Edge.Edge;
import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.DesertTerrain;
import Model.Terrain.MountainTerrain;
import Model.Terrain.PastureTerrain;
import Model.Terrain.RockTerrain;
import Model.Terrain.SeaTerrain;
import Model.Terrain.Terrain;
import Model.Terrain.WoodsTerrain;
import Model.Utility.HexaIndex;

public class BuildTileFactory {
    private TileState state;
    private int NUMEDGES = 6;
    private Terrain t;
    List<Integer> list;
    Map<HexaIndex, Edge> edgeMap;

    public BuildTileFactory() {
        edgeMap = new HashMap<>(NUMEDGES);
        list = new ArrayList<>();
    }

    public BuildTile createTile(String terrainType, int[] riverIndices) throws RuntimeException{
        list.clear();
        edgeMap.clear();
        for (int riverIndex : riverIndices) {
            list.add(riverIndex);
        }

        this.t = getTerrain(terrainType);

        return state.placeRivers();
    }

    private Terrain getTerrain(String terrain){
        terrain=terrain.toUpperCase();
        switch (terrain) {
            case "DESERT":
                state = new desertState();
                return new DesertTerrain();
            case "MOUNTAIN":
                state = new mountainState();
                return new MountainTerrain();
            case "PASTURE":
                state = new normalState();
                return new PastureTerrain();
            case "ROCK":
                state = new normalState();
                return new RockTerrain();
            case "WOODS":
                state = new normalState();
                return new WoodsTerrain();
            case "SEA":
                state = new seaState();
                return new SeaTerrain();
            default: throw new RuntimeException("Invalid Terrain Type in constructor");
        }
    }

    private class seaState implements TileState{

        @Override
        public BuildTile placeRivers() {
            if (!list.isEmpty()){
                return null;
            }
            for (int i = 1; i < NUMEDGES+1; i++) {
                try {
                    edgeMap.put(HexaIndex.createIndex(i), new SeaEdge());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return new BuildTile(t, edgeMap);
        }
    }

    private class normalState implements TileState{

        @Override
        public BuildTile placeRivers() {
            for (int i = 1; i < NUMEDGES+1; i++) {
                if(list.contains(i)){
                    try {
                        edgeMap.put(HexaIndex.createIndex(i), new RiverEdge());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        edgeMap.put(HexaIndex.createIndex(i), new LandEdge());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return new BuildTile(t, edgeMap);
        }
    }

    private class mountainState implements TileState{

        @Override
        public BuildTile placeRivers() {
            if (list.size() > 1){
                return null;
            }

            for (int i = 1; i < NUMEDGES+1; i++) {
                if(list.contains(i)){
                    try {
                        edgeMap.put(HexaIndex.createIndex(i), new RiverEdge());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        edgeMap.put(HexaIndex.createIndex(i), new LandEdge());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return new BuildTile(t, edgeMap);
        }
    }

    private class desertState implements TileState{

        @Override
        public BuildTile placeRivers() {

            if (list.size() == 2 && Math.abs(list.get(1) - list.get(0)) == 3){
                return null;
            }

            for (int i = 1; i < NUMEDGES+1; i++) {
                if(list.contains(i)){
                    try {
                        edgeMap.put(HexaIndex.createIndex(i), new RiverEdge());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        edgeMap.put(HexaIndex.createIndex(i), new LandEdge());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return new BuildTile(t, edgeMap);
        }
    }
}
