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
    private int height, width;
    GameTile[][] map;

    HexaVertex v1;
    HexaVertex v2;
    HexaVertex v3;
    HexaVertex v4;
    HexaVertex v5;
    HexaVertex v6;
    HexaVertex v7;
    HexaVertex v8;
    HexaVertex v9;
    HexaVertex v10;
    HexaVertex v11;
    HexaVertex v12;

    public MapGenerator(int height, int width){
        try {
            v1 = HexaVertex.createVertex(1);
            v2 = HexaVertex.createVertex(2);
            v3 = HexaVertex.createVertex(3);
            v4 = HexaVertex.createVertex(4);
            v5 = HexaVertex.createVertex(5);
            v6 = HexaVertex.createVertex(6);
            v7 = HexaVertex.createVertex(7);
            v8 = HexaVertex.createVertex(8);
            v9 = HexaVertex.createVertex(9);
            v10 = HexaVertex.createVertex(10);
            v11 = HexaVertex.createVertex(11);
            v12 = HexaVertex.createVertex(12);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.height = height;
        this.width = width;
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
        map = new GameTile[this.width][this.height];

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
        GameTile adjacentTile;

        RegionMap myRegionMap = tile.getRegionMap();
        RegionMap otherRegionMap;

        List<VertexPair> pairs;

        for(HexaIndex index : HexaIndex.getAllPossible()){
            ILocation loc = location.getLocationAtIndex(index);
            if(!locationInBounds(loc)){
                continue;
            }
            adjacentTile = getTileAt(loc);

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
                    myVerticies.add(new VertexPair(v7, v10));
                    myVerticies.add(new VertexPair(v10, v7));
                break;
            case 2: myVerticies.add(new VertexPair(v2, v6));
                    myVerticies.add(new VertexPair(v3, v5));
                    myVerticies.add(new VertexPair(v8, v11));
                    myVerticies.add(new VertexPair(v11, v8));
                break;
            case 3: myVerticies.add(new VertexPair(v3, v1));
                    myVerticies.add(new VertexPair(v4, v6));
                    myVerticies.add(new VertexPair(v9, v12));
                    myVerticies.add(new VertexPair(v12, v9));
                break;
            case 4: myVerticies.add(new VertexPair(v4, v2));
                    myVerticies.add(new VertexPair(v5, v1));
                    myVerticies.add(new VertexPair(v10, v7));
                    myVerticies.add(new VertexPair(v7, v10));
                break;
            case 5: myVerticies.add(new VertexPair(v5, v3));
                    myVerticies.add(new VertexPair(v6, v2));
                    myVerticies.add(new VertexPair(v11, v8));
                    myVerticies.add(new VertexPair(v8, v11));
                break;
            case 6: myVerticies.add(new VertexPair(v6, v4));
                    myVerticies.add(new VertexPair(v1, v3));
                    myVerticies.add(new VertexPair(v12, v9));
                    myVerticies.add(new VertexPair(v9, v12));
                break;
            }
        return myVerticies;
    }

    private boolean locationInBounds(ILocation location){
        if(location.getCol() >= this.width || location.getCol() < 0 || location.getRow() >= this.height || location.getRow() < 0){
            return false;
        }
        return true;
    }
}
