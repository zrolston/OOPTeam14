package Gameplay.Model.Tile;

import Gameplay.Model.Utility.HexaVertex;

import java.util.List;
import java.util.Map;

public class RegionMap {
    Map<List<HexaVertex>, Region> regionMap;

    public RegionMap(Map<List<HexaVertex>, Region> regionMap){
        this.regionMap = regionMap;
    }

    public Region getRegionAt(HexaVertex vertex){
        return regionMap.get(vertex);
    }
}
