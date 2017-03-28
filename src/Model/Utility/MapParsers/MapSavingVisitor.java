package Model.Utility.MapParsers;

import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.*;
import Model.Visitor.TerrainVisitor;
import Model.Visitor.TileVisitor;

/**
 * Created by jordi on 3/28/2017.
 */
public class MapSavingVisitor implements TileVisitor {

    TerrainType terain;

    @Override
    public void visitSea(SeaTerrain sea) {
        terain=TerrainType.SEA;
    }

    @Override
    public void visitRock(RockTerrain rock) {
        terain=TerrainType.ROCK;
    }

    @Override
    public void visitDesert(DesertTerrain desert) {
        terain=TerrainType.DESERT;
    }

    @Override
    public void visitPasture(PastureTerrain pasture) {
        terain=TerrainType.PASTURE;
    }

    @Override
    public void visitWoods(WoodsTerrain woods) {
        terain=TerrainType.WOODS;
    }

    @Override
    public void visitMountain(MountainTerrain mountain) {
        terain=TerrainType.MOUNTAIN;
    }

    @Override
    public void visitSeaEdge(SeaEdge seaEdge) {

    }

    @Override
    public void visitLandEdge(LandEdge landEdge) {

    }

    @Override
    public void visitRiverEdge(RiverEdge riverEdge) {

    }
}
