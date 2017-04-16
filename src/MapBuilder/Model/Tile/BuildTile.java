package MapBuilder.Model.Tile;

import java.util.HashMap;
import java.util.Map;

import Gameplay.Model.Visitors.GameTileVisitor;
import MapBuilder.Model.Edge.Edge;
import MapBuilder.Model.Edge.EdgeMap;
import MapBuilder.Model.Terrain.Terrain;
import MapBuilder.Model.Utility.HexaIndex;
import MapBuilder.Model.Visitor.TileVisitor;

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

    @Override
    public void accept(GameTileVisitor v) {
        /* Do nothing */
    }

    public Edge getEdgeAt(HexaIndex index) {
        return edgeMap.getEdgeAt(index);
    }
}
