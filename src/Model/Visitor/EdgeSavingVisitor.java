package Model.Visitor;

import Model.Edge.*;
import Model.Terrain.*;
import Model.Utility.HexaIndex;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Cameron on 3/28/2017.
 */
public class EdgeSavingVisitor implements TileVisitor {
    private int currentEdgeIndex;
    private ArrayList<Integer> riverIndices;

    public EdgeSavingVisitor(){
        currentEdgeIndex = 0;
        riverIndices = new ArrayList<>();
    }

    @Override
    public void visitEdgeMap(EdgeMap edgeMap) {
        currentEdgeIndex = 0;
        riverIndices = new ArrayList<>();
        //Take care of the traversal
        Map<HexaIndex, Edge> edges = edgeMap.getEdges();
        edges.forEach(
                (index, edge ) -> {
                    currentEdgeIndex = index.getValue() - 1;
                    edge.accept(this);
                }
        );
    }

    @Override
    public void visitSeaEdge(SeaEdge seaEdge) {

    }

    @Override
    public void visitLandEdge(LandEdge landEdge) {

    }

    @Override
    public void visitRiverEdge(RiverEdge riverEdge) {
        riverIndices.add(currentEdgeIndex);
    }

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
}
