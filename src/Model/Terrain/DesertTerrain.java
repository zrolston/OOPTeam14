package Model.Terrain;

import Model.Visitor.TerrainVisitor;

public class DesertTerrain extends Terrain {
    @Override
    public void accept(TerrainVisitor v) {
        v.visitDesert(this);
    }
}
