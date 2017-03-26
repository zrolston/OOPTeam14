package Model.Terrain;

import Model.Visitor.TerrainVisitor;

public class MountainTerrain extends Terrain{
    @Override
    public void accept(TerrainVisitor v) {
        v.visitMountain(this);
    }
}
