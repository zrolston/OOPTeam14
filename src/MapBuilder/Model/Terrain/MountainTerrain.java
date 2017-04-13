package MapBuilder.Model.Terrain;

import MapBuilder.Model.Visitor.TerrainVisitor;

public class MountainTerrain extends Terrain{
    @Override
    public void accept(TerrainVisitor v) {
        v.visitMountain(this);
    }
}
