package Model.Terrain;

import Model.Visitor.TerrainVisitor;

public abstract class Terrain {
    public abstract void accept(TerrainVisitor v);
}
