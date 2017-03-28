package Model.Tile;

import Model.Edge.Edge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.Terrain;
import Model.Utility.HexaIndex;
import Model.Visitor.TileVisitor;

import java.util.HashMap;
import java.util.Map;

public class BuildTile extends Tile {
    private Map<HexaIndex, Edge> edgeMap;

    public BuildTile(Terrain terrain, Map<HexaIndex, Edge> edgeMapping){
        super(terrain);
        this.edgeMap = new HashMap<>(edgeMapping);
    }

    public Map<HexaIndex, Edge> getEdges(){
        return edgeMap;
    }

    @Override
    public BuildTile clone() {
        Map<HexaIndex, Edge> newEdgeMap = new HashMap<>();
        newEdgeMap.putAll(edgeMap);
        return new BuildTile(getTerrain(), newEdgeMap);
    }

    public void rotate(){
        Map<HexaIndex, Edge> newMap = new HashMap<>();
        edgeMap.forEach((index, edge) -> {
            try {
                int newIndex = (index.getValue() + 1) % 6;
                if (newIndex == 0){
                    newIndex++;
                }
                newMap.put(HexaIndex.createIndex(newIndex), edge);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        this.edgeMap = newMap;
    }

    @Override
    public void accept(TileVisitor v) {
        getTerrain().accept(v);
        edgeMap.forEach((index, edge) -> edge.accept(v));
    }
}
