package MapBuilder.Model.Terrain;

import MapBuilder.Model.Visitor.TerrainVisitor;

public class RockTerrain extends Terrain {
    @Override
    public void accept(TerrainVisitor v) {
        v.visitRock(this);
    }
}
