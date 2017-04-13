package Gameplay.Model.Tile;

import MapBuilder.Model.Terrain.Terrain;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Visitor.TileVisitor;

public class GameTile extends Tile {
    private RegionMap regionMap;
    private Terrain terrain;

    public GameTile(Terrain terrain, RegionMap regionMap){
        super(terrain);
        this.regionMap = regionMap;
    }

    @Override
    public Tile clone() {
        return new GameTile(terrain, regionMap);
    }

    @Override
    public void accept(TileVisitor v) {

    }
}
