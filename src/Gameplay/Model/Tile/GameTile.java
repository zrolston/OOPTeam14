package Gameplay.Model.Tile;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Model.Visitors.GameTileVisitor;
import MapBuilder.Model.Terrain.Terrain;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Utility.HexaIndex;
import MapBuilder.Model.Visitor.TileVisitor;

import java.util.Iterator;
import java.util.List;

public class GameTile extends Tile {
    private RegionMap regionMap;
    private final int riverType, rotationNumber;

    public GameTile(Terrain terrain, RegionMap regionMap, int riverType, int rotationNumber){
        super(terrain);
        this.regionMap = regionMap;
        this.riverType = riverType;
        this.rotationNumber = rotationNumber;
    }

    public RegionMap getRegionMap(){
        return regionMap;
    }

    public Iterator<Region> getMyRegions(){
        return regionMap.getMyRegions();
    }

    public Region getRegionAtHexaVertex(HexaVertex hv) {
        return regionMap.getRegionAt(hv);
    }

    public List<HexaVertex> getListHexaIndexRegion(Region r) {
        return regionMap.getVertices(r);
    }

    @Override
    public Tile clone() {
        return new GameTile(getTerrain(), regionMap, riverType, rotationNumber);
    }

    @Override
    public void accept(TileVisitor v) {
    }

    @Override
    public void accept(GameTileVisitor v) {
        getTerrain().accept(v);
        v.visitRegionMap(regionMap);
    }

    public int getRiverType(){
        return riverType;
    }
    public int getRotationNumber(){
        return rotationNumber;
    }
}
