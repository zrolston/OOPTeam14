package Gameplay.Model.Utility;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Utility.GameTilePlacement;
import Gameplay.Model.Utility.HexaVertex;
import MapBuilder.Model.Utility.HexaIndex;
import MapBuilder.Model.Utility.ILocation;

import java.util.LinkedList;
import java.util.List;

public class MapGenerator {
    GameTile[][] map;

    HexaVertex v1;
    HexaVertex v2;
    HexaVertex v3;
    HexaVertex v4;
    HexaVertex v5;
    HexaVertex v6;
    HexaVertex center;

    public MapGenerator(){
        try {
            v1 = HexaVertex.createVertex(1);
            v2 = HexaVertex.createVertex(2);
            v3 = HexaVertex.createVertex(3);
            v4 = HexaVertex.createVertex(4);
            v5 = HexaVertex.createVertex(5);
            v6 = HexaVertex.createVertex(6);
            center = HexaVertex.createVertex(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class VertexPair{
        HexaVertex myVertex;
        HexaVertex otherVertext;

        VertexPair(HexaVertex v1, HexaVertex v2){
            this.myVertex = v1;
            this.otherVertext = v2;
        }
    }


    public GameTile[][] generateRegionSets(List<GameTilePlacement> placements){
        map = new GameTile[21][21];

        ILocation loc;
        GameTile tile;


        for(GameTilePlacement g : placements){
            loc = g.getLocation();
            tile = g.getTile();
            placeTileAt(loc, tile);
        }
        return map;
    }

    private void updateSets(ILocation location, GameTile tile){
        GameTile targetTile = tile;
        GameTile adjacentTile;

        RegionMap myRegionMap = tile.getRegionMap();
        RegionMap otherRegionMap;

        List<VertexPair> pairs;

        for(HexaIndex index : HexaIndex.getAllPossible()){

            adjacentTile = getTileAt(location.getLocationAtIndex(index));

            if(adjacentTile == null){
                continue;
            }

            otherRegionMap = adjacentTile.getRegionMap();

            pairs = getVerticies(index);

            connectTiles(pairs, myRegionMap, otherRegionMap);
        }
    }

    private void connectTiles(List<VertexPair> pairs, RegionMap myRegionMap, RegionMap otherRegionMap) {
        Region myRegion;
        Region otherRegion;

        for(VertexPair vPair : pairs){
            myRegion = myRegionMap.getRegionAt(vPair.myVertex);
            otherRegion = otherRegionMap.getRegionAt(vPair.otherVertext);

            mergeRegions(myRegion, otherRegion);
        }
    }

    private void mergeRegions(Region myRegion, Region otherRegion) {
        if(myRegion == null || otherRegion == null){
            return;
        }

        otherRegion.accept(myRegion.getConnectionGenerator());

        myRegion.accept(otherRegion.getConnectionGenerator());
    }

    private GameTile getTileAt(ILocation loc){
        return map[loc.getRow()][loc.getCol()];
    }

    private void placeTileAt(ILocation loc, GameTile tile){
        map[loc.getRow()][loc.getCol()] = tile;
        updateSets(loc, tile);
    }

    private List<VertexPair> getVerticies(HexaIndex index){

        List<VertexPair> myVerticies = new LinkedList<>();

        switch (index.getValue()){
            case 1: myVerticies.add(new VertexPair(v1, v5));
                    myVerticies.add(new VertexPair(v2, v4));
                break;
            case 2: myVerticies.add(new VertexPair(v2, v6));
                    myVerticies.add(new VertexPair(v3, v5));
                break;
            case 3: myVerticies.add(new VertexPair(v3, v1));
                    myVerticies.add(new VertexPair(v4, v6));
                break;
            case 4: myVerticies.add(new VertexPair(v4, v2));
                    myVerticies.add(new VertexPair(v5, v1));
                break;
            case 5: myVerticies.add(new VertexPair(v5, v3));
                    myVerticies.add(new VertexPair(v6, v2));
                break;
            case 6: myVerticies.add(new VertexPair(v6, v4));
                    myVerticies.add(new VertexPair(v1, v3));
                break;
        }

        myVerticies.add(new VertexPair(center, center));

        return myVerticies;
    }
}
