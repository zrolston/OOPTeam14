package Gameplay.Model.Tile;

import Gameplay.Model.Region.Region;
import Gameplay.Model.Utility.HexaVertex;

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
            if (hexaVertices.contains(vertex)){
                return regionMap.get(hexaVertices);
            }
        }
        return null;
    }

    public boolean contains(Region r1) {
        return regionMap.values().contains(r1);
    }

    public boolean hasRegionAt(HexaVertex vertex){
        for(List<HexaVertex> vertices : regionMap.keySet()){
            if (vertices.contains(vertex)){
                return true;
            }
        }
        return false;
    }

    public Map<List<HexaVertex>, Region> getRegionMap(){
        return regionMap;
    }

    public Iterator<Region> getMyRegions(){
        return regionMap.values().iterator();
    }
}
