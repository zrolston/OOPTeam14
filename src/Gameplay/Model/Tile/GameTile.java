package Gameplay.Model.Tile;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Visitors.GameTileVisitor;
import MapBuilder.Model.Terrain.Terrain;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Visitor.TileVisitor;

import java.util.Iterator;

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
