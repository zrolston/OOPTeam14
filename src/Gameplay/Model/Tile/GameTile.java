package Gameplay.Model.Tile;

import Gameplay.Model.Visitors.GameTileVisitor;
import MapBuilder.Model.Terrain.Terrain;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Visitor.TileVisitor;

public class GameTile extends Tile {
    private RegionMap regionMap;

    public GameTile(Terrain terrain, RegionMap regionMap){
        super(terrain);
        this.regionMap = regionMap;
    }

    public RegionMap getRegionMap(){
        return regionMap;
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
}
