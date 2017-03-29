package Model.Utility.MapParsers;

import java.util.ArrayList;
import java.util.Map;

import Model.Edge.Edge;
import Model.Edge.EdgeMap;
import Model.Edge.LandEdge;
import Model.Edge.RiverEdge;
import Model.Edge.SeaEdge;
import Model.Terrain.DesertTerrain;
import Model.Terrain.MountainTerrain;
import Model.Terrain.PastureTerrain;
import Model.Terrain.RockTerrain;
import Model.Terrain.SeaTerrain;
import Model.Terrain.TerrainType;
import Model.Terrain.WoodsTerrain;
import Model.Utility.HexaIndex;
import Model.Visitor.TileVisitor;

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
