package Model.Tile;

import Model.Edge.Edge;
import Model.Terrain.Terrain;
import Model.Visitor.TileVisitor;

import java.util.HashMap;
import java.util.Map;

public class BuildTile extends Tile {
    private Map<Integer, Edge> edgeMap;

    public BuildTile(Terrain terrain, Map<Integer, Edge> edgeMapping){
        super(terrain);
        this.edgeMap = new HashMap<>(edgeMapping);
    }

    public Map<Integer, Edge> getEdges(){
        return edgeMap;
    }

    @Override
    public void accept(TileVisitor v) {
        getTerrain().accept(v);
    }
}
