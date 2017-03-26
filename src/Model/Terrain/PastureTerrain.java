package Model.Terrain;

import Model.Visitor.TerrainVisitor;

public class PastureTerrain extends Terrain {
    @Override
    public void accept(TerrainVisitor v) {
        v.visitPasture(this);
    }
}
