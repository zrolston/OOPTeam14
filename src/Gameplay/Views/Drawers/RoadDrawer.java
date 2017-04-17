package Gameplay.Views.Drawers;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Views.Utility.PixelMap;
import Gameplay.Views.Utility.PolygonProportions.RegionVertexUtility;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.Utility.PixelPoint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Willie on 4/16/2017.
 */
public class RoadDrawer {

    public List<Line> getAllRoads() {
        List<Line> roads = new ArrayList<Line>();
        GameModelFacade gmf = GameModelFacade.getInstance();
        Map<Region, Region> roadMap = gmf.getAllRoads();

        for (Region r1 : roadMap.keySet()) {
            Region r2 = roadMap.get(r1);
            roads.add(new Line(getRegionCenter(r1), getRegionCenter(r2)));
        }

        return roads;
    }

    private PixelPoint getRegionCenter(Region r) {
        GameModelFacade gmf = GameModelFacade.getInstance();
        GameMap gm = gmf.debugGetMap();
        GameTile tile = r.getParentTile();
        return RegionVertexUtility.getRegionCenter(tile, tile.getListHexaIndexRegion(r));
    }

}