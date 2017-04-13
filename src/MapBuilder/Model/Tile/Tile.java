package MapBuilder.Model.Tile;

import MapBuilder.Model.Terrain.Terrain;
import MapBuilder.Model.Visitor.TileVisitor;

public abstract class Tile {
    private Terrain terrain;

    protected Tile(Terrain terrain){
        this.terrain = terrain;
    }

    public abstract Tile clone();

    public Terrain getTerrain(){
        return this.terrain;
    }

    public abstract void accept(TileVisitor v);
}
