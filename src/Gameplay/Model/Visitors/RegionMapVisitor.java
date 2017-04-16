package Gameplay.Model.Visitors;

import Gameplay.Model.Tile.RegionMap;

public interface RegionMapVisitor {
    void visitRegionMap(RegionMap regionMap);
}
