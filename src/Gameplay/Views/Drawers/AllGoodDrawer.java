package Gameplay.Views.Drawers;

import Gameplay.Model.Goods.Good;
import Gameplay.Model.Goods.GoodsBag;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Producer.Producer;
import Gameplay.Model.Region.Region;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Views.Utility.PixelMap;
import MapBuilder.Model.Utility.HexLocation;
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
        GameMap gm = gmf.debugGetMap();
//        GameTile[][] tiles = gm.getTiles();
//        GoodDrawingVisitor gdv = new GoodDrawingVisitor();
//        for (int i = 0; i < tiles.length; i++) {
//            for (int j = 0; j < tiles[0].length; j++) {
//                if (tiles[i][j] == null)
//                    continue;
//                PixelPoint origin = PixelMap.getMapTileOrigin(new HexLocation(i,j));
//                RegionMap regionMap = tiles[i][j].getRegionMap();
//                for (List<HexaVertex> vertices : regionMap.getRegionMap().keySet()) {
//                    gdv.setOrigin(new PixelPoint(origin.getX() + 20, origin.getY() + 20));
//                    GoodsBag gb = gmf.getGoodsBag(regionMap.getRegionAt(vertices.get(0)));
//                    if (gb == null)
//                        continue;
//                    List<Good> goods = gb.getGoods();
//                    for (Good good : goods) {
//                        good.accept(gdv);
//                        images.add(gdv.getImageWithLocation());
//                    }
//                }
//            }
//        }
        List<Region> regions = gmf.getAllRegionsWithGoodsBag();
        for (Region region : regions) {
            GameTile tile = region.getParentTile();
            HexLocation location = gm.getHexLocation(tile);
            List<HexaVertex> tile.getListHexaIndexRegion(region);
        }
        return images;
    }

}
