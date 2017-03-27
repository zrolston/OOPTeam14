package Model.Map;

import Model.Edge.Edge;
import Model.Utility.HexaIndex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Slot {
    private Map<HexaIndex, Edge> edges;

    public Slot(){
        edges = new HashMap<HexaIndex, Edge>();
    }

    public boolean checkMatch(Map<HexaIndex, Edge> inputMap){

        boolean match = true;

        for(HexaIndex i : edges.keySet()){

            match = edges.get(i).matchesWith(inputMap.get(i));

            if(!match){
                return false;
            }
        }

        return true;
    }

    public void addEdge(HexaIndex index, Edge edge){
        edges.put(index, edge);
    }

    public void removeEdge(HexaIndex index){
        edges.remove(index);
    }

    public Map<HexaIndex,Edge> getEdges() {
        return edges;
    }

    public boolean hasEdge(HexaIndex index) {
        if(edges.get(index) == null){
            return false;
        }
        return true;
    }

    public boolean isEmpty() {
        return edges.isEmpty();
    }

    public Collection<Edge> getAllEdges() {
        return edges.values();
    }
}
