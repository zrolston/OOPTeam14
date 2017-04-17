package Gameplay.Model.Tile;

import Gameplay.Model.BuildAbilities.Neutral.*;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Region.LandRegion;
import Gameplay.Model.Region.RiverRegion;
import Gameplay.Model.Region.SeaRegion;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Model.Utility.RiverConvention;
import MapBuilder.Model.Terrain.*;

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameTileBuilder {
    private Map<List<HexaVertex>, Region> regionHashMap;
    private TileState state;
    private int riverType, rotationNumber;
    private RiverConvention riverConvention;
    private final PlayerID nID = PlayerID.getNeutralPlayerID();

    public GameTileBuilder(RiverConvention riverConvention) {
        this.riverConvention = riverConvention;
        this.regionHashMap = new HashMap<>();
    }

    public GameTile createTile(String terrainType, ArrayList<Integer> riverIndices) throws RuntimeException {
        setState(terrainType);
        regionHashMap = new HashMap<>();
        try {
            addRegions(riverIndices);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        riverConvention.setRivers(riverIndices);
        riverType = riverConvention.getRiverType();
        rotationNumber = riverConvention.getRiverRotation();
        return new GameTile(state.getTerrain(), new RegionMap(regionHashMap), riverType, rotationNumber);
    }

    private void setState(String terrain){
        terrain=terrain.toUpperCase();
        switch (terrain) {
            case "DESERT":
                state = new DesertState();
                break;
            case "MOUNTAIN":
                state = new MountainState();
                break;
            case "PASTURE":
                state = new PastureState();
                break;
            case "ROCK":
                state = new RockState();
                break;
            case "WOODS":
                state = new WoodsState();
                break;
            case "SEA":
                state = new SeaState();
                break;
            default: throw new RuntimeException("Invalid Terrain Type in constructor");
        }
    }

    private void addRegions(ArrayList<Integer> riverIndices) throws Exception {
        switch (riverIndices.size()) {
            case 0: {
                ArrayList<HexaVertex> list = new ArrayList<>();
                for (int i = 1; i <= 12; i++) {
                    list.add(HexaVertex.createVertex(i));
                }
                regionHashMap.put(list, state.getRegion());
                break;
            }
            case 1: {
                addRivers(riverIndices);
                HexaVertex start = HexaVertex.createVertex(riverIndices.get(0)).nextVertex();
                ArrayList<HexaVertex> list = new ArrayList<>();
                list.add(start);
                HexaVertex temp = start.nextVertex();
                while (!temp.equals(start)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, state.getRegion());
                break;
            }
            case 2: {
                addRivers(riverIndices);
                HexaVertex start = HexaVertex.createVertex(riverIndices.get(0)).nextVertex();
                HexaVertex start2 = HexaVertex.createVertex(riverIndices.get(1)).nextVertex();
                ArrayList<HexaVertex> list = new ArrayList<>();
                list.add(start);
                HexaVertex temp = start.nextVertex();
                while (!temp.equals(start2)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new LandRegion());
                //new list
                list = new ArrayList<>();
                while (!temp.equals(start)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new LandRegion());
                break;
            }
            case 3: {
                addRivers(riverIndices);
                HexaVertex start = HexaVertex.createVertex(riverIndices.get(0)).nextVertex();
                HexaVertex start2 = HexaVertex.createVertex(riverIndices.get(1)).nextVertex();
                HexaVertex start3 = HexaVertex.createVertex(riverIndices.get(2)).nextVertex();
                ArrayList<HexaVertex> list = new ArrayList<>();
                list.add(start);
                HexaVertex temp = start.nextVertex();
                while (!temp.equals(start2)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new LandRegion());
                //new list
                list = new ArrayList<>();
                while (!temp.equals(start3)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new LandRegion());
                //new list
                list = new ArrayList<>();
                while (!temp.equals(start)) {
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new LandRegion());
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

    private void addRivers(ArrayList<Integer> riverIndices) throws Exception {
        ArrayList<HexaVertex> riverList = new ArrayList<>();
        for (Integer index : riverIndices) {
            riverList.add(HexaVertex.createVertex(index + 6));
        }
        regionHashMap.put(riverList, new RiverRegion());
    }

    abstract private class TileState{
        abstract Region getRegion();
        abstract Terrain getTerrain();
    }

    private class DesertState extends TileState{

        @Override
        Region getRegion() {
            return new LandRegion();
        }

        @Override
        Terrain getTerrain() {
            return new DesertTerrain();
        }
    }

    private class MountainState extends TileState{

        @Override
        Region getRegion() {
            return new LandRegion(
                    new BuildCoalBurner(nID),
                    new BuildMine(nID),
                    new BuildMint(nID),
                    new BuildPaperMill(nID),
                    new BuildRaftFactory(nID),
                    new BuildSawMill(nID),
                    new BuildStockMarket(nID),
                    new BuildStoneFactory(nID),
                    new BuildWagonFactory(nID)
            );
        }

        @Override
        Terrain getTerrain() {
            return new MountainTerrain();
        }
    }

    private class PastureState extends TileState{

        @Override
        Region getRegion() {
            return new LandRegion(
                    new BuildCoalBurner(nID),
                    new BuildMint(nID),
                    new BuildPaperMill(nID),
                    new BuildRaftFactory(nID),
                    new BuildSawMill(nID),
                    new BuildStockMarket(nID),
                    new BuildStoneFactory(nID),
                    new BuildWagonFactory(nID)
            );
        }

        @Override
        Terrain getTerrain() {
            return new PastureTerrain();
        }
    }

    private class RockState extends TileState{

        @Override
        Region getRegion() {
            return new LandRegion(
                    new BuildCoalBurner(nID),
                    new BuildMint(nID),
                    new BuildPaperMill(nID),
                    new BuildRaftFactory(nID),
                    new BuildSawMill(nID),
                    new BuildStockMarket(nID),
                    new BuildStoneFactory(nID),
                    new BuildWagonFactory(nID),
                    new BuildQuarry(nID)
            );
        }

        @Override
        Terrain getTerrain() {
            return new RockTerrain();
        }
    }

    private class WoodsState extends TileState{

        @Override
        Region getRegion() {
            return new LandRegion(
                    new BuildCoalBurner(nID),
                    new BuildMint(nID),
                    new BuildPaperMill(nID),
                    new BuildRaftFactory(nID),
                    new BuildSawMill(nID),
                    new BuildStockMarket(nID),
                    new BuildStoneFactory(nID),
                    new BuildWagonFactory(nID),
                    new BuildWoodCutter(nID)
            );
        }

        @Override
        Terrain getTerrain() {
            return new WoodsTerrain();
        }
    }

    private class SeaState extends TileState{

        @Override
        Region getRegion() {
            return new SeaRegion();
        }

        @Override
        Terrain getTerrain() {
            return new SeaTerrain();
        }
    }

}
