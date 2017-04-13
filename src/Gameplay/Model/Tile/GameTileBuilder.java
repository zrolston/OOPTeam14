package Gameplay.Model.Tile;

import Gameplay.Model.Utility.HexaVertex;
import MapBuilder.Model.Terrain.*;

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameTileBuilder {
    private Map<List<HexaVertex>, Region> regionHashMap;

    public GameTileBuilder() {
        this.regionHashMap = new HashMap<>();
    }

    public GameTile createTile(String terrainType, ArrayList<Integer> riverIndices) throws RuntimeException {
        regionHashMap.clear();
        if (riverIndices.isEmpty()) { //No rivers
            ArrayList<HexaVertex> list = new ArrayList<>();
            for (int i = 1; i < 7; i++) {
                try {
                    list.add(HexaVertex.createVertex(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            regionHashMap.put(list, new Region());  //TODO LandRegion?
        } else {
            ArrayList<HexaVertex> list = new ArrayList<>();
            try {
                list.add(HexaVertex.createVertex(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            regionHashMap.put(list, new Region());  //TODO RiverRegion?
            try {
                addRegions(riverIndices);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new GameTile(
                getTerrain(terrainType),
                new RegionMap(regionHashMap)
        );
    }

    private Terrain getTerrain(String terrain){
        terrain=terrain.toUpperCase();
        switch (terrain) {
            case "DESERT":
                return new DesertTerrain();
            case "MOUNTAIN":
                return new MountainTerrain();
            case "PASTURE":
                return new PastureTerrain();
            case "ROCK":
                return new RockTerrain();
            case "WOODS":
                return new WoodsTerrain();
            case "SEA":
                return new SeaTerrain();
            default: throw new RuntimeException("Invalid Terrain Type in constructor");
        }
    }

    private void addRegions(ArrayList<Integer> riverIndices) throws Exception {
        HexaVertex start = HexaVertex.createVertex(riverIndices.get(0));
        switch (riverIndices.size()) {
            case 1: {
                ArrayList<HexaVertex> list = new ArrayList<>();
                list.add(start);
                HexaVertex temp = start.nextVertex();
                while (!temp.equals(start)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                break;
            }
            case 2: {
                HexaVertex start2 = HexaVertex.createVertex(riverIndices.get(1));
                ArrayList<HexaVertex> list = new ArrayList<>();
                list.add(start);
                HexaVertex temp = start.nextVertex();
                while (!temp.equals(start2)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                //new list
                list = new ArrayList<>();
                while (!temp.equals(start)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                break;
            }
            case 3: {
                HexaVertex start2 = HexaVertex.createVertex(riverIndices.get(1));
                HexaVertex start3 = HexaVertex.createVertex(riverIndices.get(2));
                ArrayList<HexaVertex> list = new ArrayList<>();
                list.add(start);
                HexaVertex temp = start.nextVertex();
                while (!temp.equals(start2)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                //new list
                list = new ArrayList<>();
                while (!temp.equals(start3)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                //new list
                list = new ArrayList<>();
                while (!temp.equals(start)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                break;
            }
            default:
                try {
                    throw new BadAttributeValueExpException("Error during tile building: river discrepancy!");
                } catch (BadAttributeValueExpException e) {
                    e.printStackTrace();
                }
        }
    }

}
