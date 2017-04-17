package Gameplay.Views.Drawers;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.Utility.PolygonProportions.RegionVertexUtility;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Willie on 4/16/2017.
 */
public class BridgeDrawer {

    public List<Line> getAllBridges() {
        List<Line> bridges = new ArrayList<Line>();
        GameModelFacade gmf = GameModelFacade.getInstance();
        Map<Region, Region> bridgeMap = gmf.getAllBridges();

        for (Region r1 : bridgeMap.keySet()) {
            Region r2 = bridgeMap.get(r1);
            PixelPoint start = getRegionCenter(r1);
            PixelPoint end = getRegionCenter(r2);
            PixelPoint middle = average(start, end);
            PixelPoint bridgeStart = average(start, middle);
            PixelPoint bridgeEnd = average(middle, end);
            bridges.add(new Line(bridgeStart, bridgeEnd, new Color(136,69,19), 15));
        }

        return bridges;
    }

    private PixelPoint getRegionCenter(Region r) {
        GameModelFacade gmf = GameModelFacade.getInstance();
        GameMap gm = gmf.debugGetMap();
        GameTile tile = r.getParentTile();
        return RegionVertexUtility.getRegionCenter(tile, tile.getListHexaIndexRegion(r));
    }

    private PixelPoint average(PixelPoint start, PixelPoint end) {
        return new PixelPoint((start.getX() + end.getX())/2, (start.getY() + end.getY())/2);
    }

}
