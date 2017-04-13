package MapBuilder.Model.Map;

import java.util.Map;

import MapBuilder.Model.Edge.Edge;
import MapBuilder.Model.Edge.EdgeMap;
import MapBuilder.Model.Edge.LandEdge;
import MapBuilder.Model.Edge.RiverEdge;
import MapBuilder.Model.Edge.SeaEdge;
import MapBuilder.Model.Utility.HexaIndex;
import MapBuilder.Model.Visitor.EdgeVisitor;

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
