package Model.Edge;

import Model.Visitor.EdgeVisitor;

public abstract class Edge {

    public abstract void accept(EdgeVisitor ev);
    public abstract boolean matchesWith(Edge edge);
    public abstract boolean matchesWith(SeaEdge seaEdge);
    public abstract boolean matchesWith(LandEdge landEdge);
    public abstract boolean matchesWith(RiverEdge riverEdge);

}
