package MapBuilder.Model.Visitor;

import MapBuilder.Model.Terrain.DesertTerrain;
import MapBuilder.Model.Terrain.MountainTerrain;
import MapBuilder.Model.Terrain.PastureTerrain;
import MapBuilder.Model.Terrain.RockTerrain;
import MapBuilder.Model.Terrain.SeaTerrain;
import MapBuilder.Model.Terrain.WoodsTerrain;

public interface TerrainVisitor {
    void visitSea(SeaTerrain sea);
    void visitRock(RockTerrain rock);
    void visitDesert(DesertTerrain desert);
    void visitPasture(PastureTerrain pasture);
    void visitWoods(WoodsTerrain woods);
    void visitMountain(MountainTerrain mountain);
}
