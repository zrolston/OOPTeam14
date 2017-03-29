package Model.Visitor;

import Model.Terrain.DesertTerrain;
import Model.Terrain.MountainTerrain;
import Model.Terrain.PastureTerrain;
import Model.Terrain.RockTerrain;
import Model.Terrain.SeaTerrain;
import Model.Terrain.WoodsTerrain;

public interface TerrainVisitor {
    void visitSea(SeaTerrain sea);
    void visitRock(RockTerrain rock);
    void visitDesert(DesertTerrain desert);
    void visitPasture(PastureTerrain pasture);
    void visitWoods(WoodsTerrain woods);
    void visitMountain(MountainTerrain mountain);
}
