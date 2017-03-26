package Model.Visitor;

import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;

public interface EdgeVisitor {
    void visitSeaEdge(SeaEdge seaEdge);
    void visitLandEdge(LandEdge landEdge);
    void visitRiverEdge(RiverEdge riverEdge);
}
