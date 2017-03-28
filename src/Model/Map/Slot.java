package Model.Map;

import Model.Edge.Edge;
import Model.Edge.EdgeMap;
import Model.Utility.HexaIndex;
import Model.Visitor.EdgeVisitor;

public class Slot {
    private EdgeMap edges;

    public Slot(){
        edges = new EdgeMap();
    }

    public boolean checkMatch(EdgeMap inputMap){
        return edges.matches(inputMap);
    }

    public void addEdge(HexaIndex index, Edge edge){
        edges.addEdge(index, edge);
    }

    public void removeEdge(HexaIndex index){
        edges.removeEdge(index);
    }

    public EdgeMap getEdges() {
        return edges;
    }

    public boolean hasEdge(HexaIndex index) {
        return edges.hasEdge(index);
    }

    public boolean hasEdges() {
        return !this.edges.isEmpty();
    }

    public int edgeSize(){
        return edges.size();
    }

    public void accept(EdgeVisitor v){
        edges.accept(v);
    }
}
