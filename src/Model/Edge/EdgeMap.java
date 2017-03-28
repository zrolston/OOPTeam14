package Model.Edge;

import Model.Utility.HexaIndex;
import Model.Visitor.EdgeVisitor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cameron on 3/28/2017.
 */
public class EdgeMap {
    private Map<HexaIndex, Edge> edgeMap;

    public EdgeMap(Map<HexaIndex, Edge> mapping){
        this.edgeMap = mapping;
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

    public void accept(EdgeVisitor v){
        v.visitEdgeMap(this);
    }
}
