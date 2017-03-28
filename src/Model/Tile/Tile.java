package Model.Tile;

import Model.Terrain.Terrain;
import Model.Visitor.EdgeVisitor;
import Model.Visitor.TileVisitor;

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
