package MapBuilder.Model.Utility.MapParsers;

import java.util.ArrayList;
import java.util.Map;

import MapBuilder.Model.Edge.Edge;
import MapBuilder.Model.Edge.EdgeMap;
import MapBuilder.Model.Edge.LandEdge;
import MapBuilder.Model.Edge.RiverEdge;
import MapBuilder.Model.Edge.SeaEdge;
import MapBuilder.Model.Terrain.DesertTerrain;
import MapBuilder.Model.Terrain.MountainTerrain;
import MapBuilder.Model.Terrain.PastureTerrain;
import MapBuilder.Model.Terrain.RockTerrain;
import MapBuilder.Model.Terrain.SeaTerrain;
import MapBuilder.Model.Terrain.TerrainType;
import MapBuilder.Model.Terrain.WoodsTerrain;
import MapBuilder.Model.Utility.HexaIndex;
import MapBuilder.Model.Visitor.TileVisitor;

/**
 * Created by jordi on 3/28/2017.
 */
public class MapSavingVisitor implements TileVisitor {
    private int currentEdgeIndex;
    private ArrayList<Integer> riverIndices;
    private TerrainType terrain;

    @Override
    public void visitSea(SeaTerrain sea) {
        terrain = TerrainType.SEA;
    }

    @Override
    public void visitRock(RockTerrain rock) {
        terrain = TerrainType.ROCK;
    }

    @Override
    public void visitDesert(DesertTerrain desert) {
        terrain = TerrainType.DESERT;
    }

    @Override
    public void visitPasture(PastureTerrain pasture) {
        terrain = TerrainType.PASTURE;
    }

    @Override
    public void visitWoods(WoodsTerrain woods) {
        terrain = TerrainType.WOODS;
    }

    @Override
    public void visitMountain(MountainTerrain mountain) {
        terrain = TerrainType.MOUNTAIN;
    }

    @Override
    public void visitEdgeMap(EdgeMap edgeMap) {
        currentEdgeIndex = 0;
        riverIndices = new ArrayList<>();
        //Take care of the traversal
        Map<HexaIndex, Edge> edges = edgeMap.getEdges();
        edges.forEach(
                (index, edge) -> {
                    currentEdgeIndex = index.getValue();
                    edge.accept(this);
                }
        );
    }

    @Override
    public void visitSeaEdge(SeaEdge seaEdge) {

    }

    @Override
    public void visitLandEdge(LandEdge landEdge) {

    }

    @Override
    public void visitRiverEdge(RiverEdge riverEdge) {
        riverIndices.add(currentEdgeIndex);
    }

    public ArrayList<Integer> getRiverIndices() {
        return riverIndices;
    }

    public TerrainType getTerrain() {
        return terrain;
    }
}
