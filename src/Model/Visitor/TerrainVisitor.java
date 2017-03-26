package Model.Visitor;

import Model.Terrain.*;

public interface TerrainVisitor {
    void visitSea(SeaTerrain sea);
    void visitRock(RockTerrain rock);
    void visitDesert(DesertTerrain desert);
    void visitPasture(PastureTerrain pasture);
    void visitWoods(WoodsTerrain woods);
    void visitMountain(MountainTerrain mountain);
}
