package Gameplay.Model.Tile;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.HexaVertex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RegionMap {
    private Map<List<HexaVertex>, Region> regionMap;

    public RegionMap(Map<List<HexaVertex>, Region> regionMap){
        this.regionMap = regionMap;
    }

    public Region getRegionAt(HexaVertex vertex){
        for (List<HexaVertex> hexaVertices : regionMap.keySet()) {
            for (HexaVertex vert : hexaVertices)
                if (vert.getValue() == vertex.getValue())
                    return regionMap.get(hexaVertices);
        }
        return null;
    }

    public boolean contains(Region r1) {
        return regionMap.values().contains(r1);
    }

    public List<HexaVertex> getVertices(Region r1) {
        for (List<HexaVertex> vertices : regionMap.keySet())
            if (regionMap.get(vertices) == r1)
                return vertices;
        return null;
    }

    public boolean hasRegionAt(HexaVertex vertex){
        for(List<HexaVertex> vertices : regionMap.keySet()){
            for (HexaVertex vert : vertices)
                if (vert.getValue() == vertex.getValue())
                    return true;
        }
        return false;
    }

    public Map<List<HexaVertex>, Region> getRegionMap(){
        return regionMap;
    }

    public Iterator<Region> getMyRegions(){
        return regionMap.values().iterator();
    }

    public Region getRiver() {
        List<HexaVertex> vertices = new ArrayList<>();
        Region region;

        try {
            vertices.add(HexaVertex.createVertex(7));
            vertices.add(HexaVertex.createVertex(8));
            vertices.add(HexaVertex.createVertex(9));
            vertices.add(HexaVertex.createVertex(10));
            vertices.add(HexaVertex.createVertex(11));
            vertices.add(HexaVertex.createVertex(12));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (HexaVertex v: vertices) {
            region = getRegionAt(v);
            if(region != null){
                return region;
            }
        }
        return null;
    }
}
