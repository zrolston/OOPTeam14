package Gameplay.Model.Tile;

import Gameplay.Model.Utility.HexaVertex;
import MapBuilder.Model.Edge.*;
import MapBuilder.Model.Terrain.*;
import MapBuilder.Model.Utility.HexaIndex;
import MapBuilder.Model.Visitor.TileVisitor;

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileBuildingVisitor implements TileVisitor {
    private Map<List<HexaVertex>, Region> regionHashMap;
    private int currentEdgeIndex;
    private ArrayList<Integer> riverIndices;
    private Terrain terrain;

    public TileBuildingVisitor(){
        regionHashMap = new HashMap<>();
    }

    private void addRegions() throws Exception { //precondition: not empty
        HexaVertex start = HexaVertex.createVertex(riverIndices.get(0));
        switch (riverIndices.size()){
            case 1: {
                ArrayList<HexaVertex> list = new ArrayList<>();
                list.add(start);
                HexaVertex temp = start.nextVertex();
                while(!temp.equals(start)){
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
                while(!temp.equals(start2)){
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                //new list
                list = new ArrayList<>();
                while(!temp.equals(start)){
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                break;
            }
            case 3:{
                HexaVertex start2 = HexaVertex.createVertex(riverIndices.get(1));
                HexaVertex start3 = HexaVertex.createVertex(riverIndices.get(2));
                ArrayList<HexaVertex> list = new ArrayList<>();
                list.add(start);
                HexaVertex temp = start.nextVertex();
                while(!temp.equals(start2)){
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                //new list
                list = new ArrayList<>();
                while(!temp.equals(start3)){
                    list.add(temp);
                    temp = temp.nextVertex();
                }
                regionHashMap.put(list, new Region());  //TODO
                //new list
                list = new ArrayList<>();
                while(!temp.equals(start)){
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

    @Override
    public void visitEdgeMap(EdgeMap edgeMap) {
        currentEdgeIndex = 0;
        riverIndices = new ArrayList<>();
        //Take care of the traversal
        Map<HexaIndex, Edge> edges = edgeMap.getEdges();
        edges.forEach(
                (index, edge ) -> {
                    currentEdgeIndex = index.getValue();
                    edge.accept(this);
                }
        );
        if(riverIndices.isEmpty()){ //No rivers
            ArrayList<HexaVertex> list = new ArrayList<>();
            for(int i = 1; i < 7; i++){
                try {
                    list.add(HexaVertex.createVertex(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            regionHashMap.put(list, new Region());  //TODO LandRegion?
        }
        else{
            ArrayList<HexaVertex> list = new ArrayList<>();
            try {
                list.add(HexaVertex.createVertex(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            regionHashMap.put(list, new Region());  //TODO RiverRegion?
            try {
                addRegions();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void visitSeaEdge(SeaEdge seaEdge) {

    }

    @Override
    public void visitLandEdge(LandEdge landEdge) {

    }

    @Override
    public void visitRiverEdge(RiverEdge riverEdge) {
        riverIndices.add(currentEdgeIndex);
    }

    @Override
    public void visitSea(SeaTerrain sea) {
        this.terrain = new SeaTerrain();
    }

    @Override
    public void visitRock(RockTerrain rock) {
        this.terrain = new RockTerrain();
    }

    @Override
    public void visitDesert(DesertTerrain desert) {
        this.terrain = new DesertTerrain();
    }

    @Override
    public void visitPasture(PastureTerrain pasture) {
        this.terrain = new PastureTerrain();
    }

    @Override
    public void visitWoods(WoodsTerrain woods) {
        this.terrain = new WoodsTerrain();
    }

    @Override
    public void visitMountain(MountainTerrain mountain) {
        this.terrain = new MountainTerrain();
    }

    public GameTile getGameTile(){
        return new GameTile(terrain, new RegionMap(regionHashMap));
    }
}
