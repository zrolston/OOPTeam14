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

/**
 * Created by Willie on 4/16/2017.
 */
public class RoadDrawer {

    public List<Line> getAllRoads() {
        List<Line> roads = new ArrayList<Line>();
        GameModelFacade gmf = GameModelFacade.getInstance();
        GameMap gm = gmf.debugGetMap();
//        GameTile[][] tiles = gm.getTiles();
//        GoodDrawingVisitor gdv = new GoodDrawingVisitor();
//        for (int i = 0; i < tiles.length; i++) {
//            for (int j = 0; j < tiles[0].length; j++) {
//                if (tiles[i][j] == null)
//                    continue;
//                RegionMap regionMap = tiles[i][j].getRegionMap();
//                Iterator<Region> regionIterator = regionMap.getMyRegions();
//                while (regionIterator.hasNext()) {
//                    Region r = regionIterator.next();
//                    List<Region> connectedRegions = r.getRegionSet().getRoadRegions();
//                    for (Region roadEnd : connectedRegions) {
//                        PixelPoint start = PixelMap.getMapTileOrigin(new HexLocation(i,j));
//                        PixelPoint end = getRegionCenter(roadEnd);
//                        roads.add(new Line(start, end));
//                    }
//                }
//            }
//        }



        return roads;
    }

    private PixelPoint getRegionCenter(Region r) {
        GameTile tile = r.getParentTile();
        tile.getListHexaIndexRegion(r);
        RegionVertexUtility.
    }

}