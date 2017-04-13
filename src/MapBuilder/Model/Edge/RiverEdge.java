package MapBuilder.Model.Edge;

import MapBuilder.Model.Visitor.EdgeVisitor;

public class RiverEdge extends Edge {
    @Override
    public void accept(EdgeVisitor ev) {
        ev.visitRiverEdge(this);
    }

    @Override
    public boolean matchesWith(Edge edge) {
        return edge.matchesWith(this);
    }

    @Override
    public boolean matchesWith(SeaEdge seaEdge) {
        return true;
    }

    @Override
    public boolean matchesWith(LandEdge landEdge) {
        return false;
    }

    @Override
    public boolean matchesWith(RiverEdge riverEdge) {
        return true;
    }
}
