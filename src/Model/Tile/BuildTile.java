package Model.Tile;

import java.util.HashMap;
import java.util.Map;

import Model.Edge.Edge;
import Model.Edge.EdgeMap;
import Model.Terrain.Terrain;
import Model.Utility.HexaIndex;
import Model.Visitor.TileVisitor;

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
    }

    @Override
    public void accept(TileVisitor v) {
        getTerrain().accept(v);
        edgeMap.accept(v);
    }

    public Edge getEdgeAt(HexaIndex index) {
        return edgeMap.getEdgeAt(index);
    }
}
