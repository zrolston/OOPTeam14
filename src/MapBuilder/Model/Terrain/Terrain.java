package MapBuilder.Model.Terrain;

import MapBuilder.Model.Visitor.TerrainVisitor;

public abstract class Terrain {
    public abstract void accept(TerrainVisitor v);
}
