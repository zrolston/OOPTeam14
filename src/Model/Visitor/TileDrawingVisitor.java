package Model.Visitor;

import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.*;

public class TileDrawingVisitor implements TileVisitor {
    @Override
    public void visitSea(SeaTerrain sea) {

    }

    @Override
    public void visitRock(RockTerrain rock) {

    }

    @Override
    public void visitDesert(DesertTerrain desert) {

    }

    @Override
    public void visitPasture(PastureTerrain pasture) {

    }

    @Override
    public void visitWoods(WoodsTerrain woods) {

    }

    @Override
    public void visitMountain(MountainTerrain mountain) {

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
