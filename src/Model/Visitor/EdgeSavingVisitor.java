package Model.Visitor;

import Model.Edge.*;
import Model.Utility.HexaIndex;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Cameron on 3/28/2017.
 */
public class EdgeSavingVisitor implements EdgeVisitor {
    private int currentEdgeIndex;
    private ArrayList<Integer> riverIndices;

    @Override
    public void visitEdgeMap(EdgeMap edgeMap) {
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
}
