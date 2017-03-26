package Model.Map;

import Model.Edge.Edge;
import Model.Utility.HexaIndex;

import java.util.HashMap;

public class Slot {
    private HashMap<HexaIndex, Edge> edges;

    public Slot(){
        edges = new HashMap<HexaIndex, Edge>();
    }

    public boolean checkMatch(HashMap<HexaIndex, Edge> inputMap){

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

    public HashMap<HexaIndex,Edge> getEdges() {
        return edges;
    }
}
