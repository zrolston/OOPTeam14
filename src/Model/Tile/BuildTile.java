package Model.Tile;

import Model.Edge.Edge;
import Model.Edge.EdgeMap;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.Terrain;
import Model.Utility.HexaIndex;
import Model.Visitor.TileVisitor;

import java.util.HashMap;
import java.util.Map;

public class BuildTile extends Tile {
    private EdgeMap edgeMap;

    public BuildTile(Terrain terrain, Map<HexaIndex, Edge> edgeMapping){
        super(terrain);
        this.edgeMap = new EdgeMap(edgeMapping);
    }

    public EdgeMap getEdges(){
        return edgeMap;
    }

    @Override
    public BuildTile clone() {
        Map<HexaIndex, Edge> newEdgeMap = new HashMap<>();
        newEdgeMap.putAll(edgeMap.getEdges());
        return new BuildTile(getTerrain(), newEdgeMap);
    }

    public void rotate(){
        edgeMap.rotate();
        /*
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
        this.edgeMap = newMap;*/
    }

    @Override
    public void accept(TileVisitor v) {
        getTerrain().accept(v);
        edgeMap.accept(v);
    }
}
