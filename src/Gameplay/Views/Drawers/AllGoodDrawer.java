package Gameplay.Views.Drawers;

import Gameplay.Model.Goods.Good;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.Utility.PolygonProportions.RegionVertexUtility;
import MapBuilder.Views.Utility.PixelPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Willie on 4/16/2017.
 */
public class AllGoodDrawer {

    public List<ImageWithLocation> getAllGoodImages() {
        List<ImageWithLocation> images = new ArrayList<ImageWithLocation>();
        GameModelFacade gmf = GameModelFacade.getInstance();
        GameMap gm = gmf.getMap();

        List<Region> regions = gmf.getAllRegionsWithGoodsBag();
        GoodDrawingVisitor gdv = new GoodDrawingVisitor();
        for (Region region : regions) {
            GameTile tile = region.getParentTile();
            PixelPoint center = RegionVertexUtility.getRegionCenter(tile, tile.getListHexaIndexRegion(region));

            GoodsBag gb = gmf.getGoodsBag(region);
            gdv.setCenter(center);
            for (Good good : gb.getGoods()) {
                good.accept(gdv);
                images.add(gdv.getImageWithLocation());
            }
        }
        return images;
    }

}
