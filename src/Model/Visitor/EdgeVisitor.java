package Model.Visitor;

import Model.Edge.EdgeMap;
import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;

public interface EdgeVisitor {
    void visitEdgeMap(EdgeMap edgeMap);
    void visitSeaEdge(SeaEdge seaEdge);
    void visitLandEdge(LandEdge landEdge);
    void visitRiverEdge(RiverEdge riverEdge);
}
