package Gameplay.Views.Drawers;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Producer.Producer;
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
public class AllProducerDrawer {

    public List<ImageWithLocation> getAllProducerImages() {
        List<ImageWithLocation> images = new ArrayList<ImageWithLocation>();
        GameModelFacade gmf = GameModelFacade.getInstance();

        List<Region> regions = gmf.getAllRegionsWithProducer();
        ProducerDrawingVisitor pdv = new ProducerDrawingVisitor();
        for (Region region : regions) {
            GameTile tile = region.getParentTile();
            PixelPoint center = RegionVertexUtility.getRegionCenter(tile, tile.getListHexaIndexRegion(region));

            Producer producer = gmf.getProducer(region);
            pdv.setCenter(center);

            producer.accept(pdv);
            images.add(pdv.getImageWithLocation());
        }
        return images;
    }

}
