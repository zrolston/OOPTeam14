package Gameplay.Model.Tile;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Visitors.GameTileVisitor;
import Gameplay.Model.Visitors.RegionMapVisitor;
import Gameplay.Model.Visitors.RiverVisitor;
import MapBuilder.Model.Terrain.Terrain;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Visitor.TileVisitor;

import java.util.Iterator;

public class GameTile extends Tile {
    private RegionMap regionMap;

    public GameTile(Terrain terrain, RegionMap regionMap){
        super(terrain);
        this.regionMap = regionMap;
    }

    public RegionMap getRegionMap(){
        return regionMap;
    }

    public Iterator<Region> getMyRegions(){
        return regionMap.getMyRegions();
    }

    @Override
    public Tile clone() {
        return new GameTile(getTerrain(), regionMap);
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
        RiverVisitor v = new RiverVisitor();
        v.visitRegionMap(regionMap);
        return v.getRiverType();
    }
    public int getRotationNumber(){
        RiverVisitor v = new RiverVisitor();
        v.visitRegionMap(regionMap);
        return v.getRotationNumber();
    }
}
