package Model.Tile;

import Model.Edge.Edge;
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
    public void accept(TileVisitor v) {
        getTerrain().accept(v);
        edgeMap.forEach((index, edge) -> edge.accept(v));
    }

    public Edge getEdgeAt(HexaIndex index) {
        return edgeMap.get(index);
    }
}
