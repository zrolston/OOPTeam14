package Gameplay.Views.Drawers;

import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Views.Utility.PixelMap;
import Gameplay.Views.Utility.PolygonProportions.RegionVertexUtility;
import MapBuilder.Model.Map.IViewMap;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.Utility.PixelPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Willie on 4/16/2017.
 */
public class AllTransporterDrawer {

    public List<ImageWithLocation> getAllTransporterImages() {
        List<ImageWithLocation> images = new ArrayList<>();
        GameModelFacade gmf = GameModelFacade.getInstance();
        GameMap gm = gmf.debugGetMap();

        List<Region> regions = gmf.getAllRegionsWithTransporter();
        TransporterDrawingVisitor tdv = new TransporterDrawingVisitor();

        for (Region region : regions) {
            GameTile tile = region.getParentTile();
            PixelPoint center = RegionVertexUtility.getRegionCenter(tile, tile.getListHexaIndexRegion(region));

            TransporterIterator transporterIterator = gmf.getTransporters(region);
            tdv.setCenter(center);
            for (int i = 0; i < transporterIterator.size(); i++) {
                transporterIterator.getTransporterAt(i).accept(tdv);
                images.add(tdv.getImageWithLocation());
            }
        }
        return images;
    }

}
