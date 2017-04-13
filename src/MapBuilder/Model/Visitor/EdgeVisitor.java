package MapBuilder.Model.Visitor;

import MapBuilder.Model.Edge.EdgeMap;
import MapBuilder.Model.Edge.LandEdge;
import MapBuilder.Model.Edge.RiverEdge;
import MapBuilder.Model.Edge.SeaEdge;

public interface EdgeVisitor {
    void visitEdgeMap(EdgeMap edgeMap);
    void visitSeaEdge(SeaEdge seaEdge);
    void visitLandEdge(LandEdge landEdge);
    void visitRiverEdge(RiverEdge riverEdge);
}
