package Gameplay.Model.Tile;

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
}
