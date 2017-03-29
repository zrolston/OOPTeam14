package Model.Map;

import java.util.Map;

import Model.Edge.Edge;
import Model.Edge.EdgeMap;
import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Utility.HexaIndex;
import Model.Visitor.EdgeVisitor;

public class RiverCountVisitor implements EdgeVisitor{

    private int riverCount;

    public RiverCountVisitor(){
        riverCount = 0;
    }

    public int getRiverCount(){
        return riverCount;
    }

    public void clearRiverCount(){
        riverCount = 0;
    }

    @Override
    public void visitEdgeMap(EdgeMap edgeMap) {
        //Take care of the traversal
        Map<HexaIndex, Edge> edges = edgeMap.getEdges();
        edges.forEach(
                (index, edge ) -> edge.accept(this)
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
        //If Slot has a river edge, it is not closed... BAD!
        riverCount++;
    }
}
