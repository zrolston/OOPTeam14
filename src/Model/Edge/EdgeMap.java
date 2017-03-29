package Model.Edge;

import java.util.HashMap;
import java.util.Map;

import Model.Utility.HexaIndex;
import Model.Visitor.EdgeVisitor;

/**
 * Created by Cameron on 3/28/2017.
 */
public class EdgeMap {
    private Map<HexaIndex, Edge> edgeMap;

    public EdgeMap(Map<HexaIndex, Edge> mapping){
        this.edgeMap = new HashMap<>(mapping);
    }

    public EdgeMap(){
        edgeMap = new HashMap<>();
    }

    public void rotate(){
        Map<HexaIndex, Edge> newMap = new HashMap<>();
        edgeMap.forEach((index, edge) -> {
            try {
                int newIndex = (index.getValue() + 1) % 6;
                if (newIndex == 0){
                    newIndex = 6;
                }
                newMap.put(HexaIndex.createIndex(newIndex), edge);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        this.edgeMap = newMap;
    }

    public Map<HexaIndex, Edge> getEdges(){
        return edgeMap;
    }

    public boolean hasEdge(HexaIndex index){
        return edgeMap.containsKey(index);
    }

    public boolean isEmpty(){
        return edgeMap.isEmpty();
    }

    public boolean matches(EdgeMap newMap){
        boolean matches = true;
        Map<HexaIndex, Edge> _newMap = newMap.getEdges();
        for (HexaIndex index : edgeMap.keySet()){
            matches = edgeMap.get(index).matchesWith(_newMap.get(index));
            if(!matches){
                return false;
            }
        }

        return true;
    }

    public void addEdge(HexaIndex index, Edge edge){
        edgeMap.put(index, edge);
    }

    public void removeEdge(HexaIndex index){
        edgeMap.remove(index);
    }

    public void accept(EdgeVisitor v){
        v.visitEdgeMap(this);
    }

    public Edge getEdgeAt(HexaIndex index){
        return edgeMap.get(index);
    }

    public int size(){
        return edgeMap.size();
    }
}
