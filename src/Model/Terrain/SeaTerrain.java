package Model.Terrain;

import Model.Visitor.TerrainVisitor;

public class SeaTerrain extends Terrain {
    @Override
    public void accept(TerrainVisitor v) {
        v.visitSea(this);
    }
}
