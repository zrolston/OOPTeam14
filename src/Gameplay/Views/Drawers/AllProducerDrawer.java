package Gameplay.Views.Drawers;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Producer.Producer;
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
public class AllProducerDrawer {

    public List<ImageWithLocation> getAllProducerImages() {
        List<ImageWithLocation> images = new ArrayList<ImageWithLocation>();
        GameModelFacade gmf = GameModelFacade.getInstance();
        GameMap gm = gmf.debugGetMap();
        GameTile[][] tiles = gm.getTiles();
        ProducerDrawingVisitor pdv = new ProducerDrawingVisitor();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                PixelPoint origin = PixelMap.getMapTileOrigin(new HexLocation(i,j));
                RegionMap regionMap = tiles[i][j].getRegionMap();
                for (List<HexaVertex> vertices : regionMap.getRegionMap().keySet()) {
                    pdv.setOrigin(new PixelPoint(origin.getX() + 20, origin.getY() + 20));
                    Producer producer = gmf.getProducer(regionMap.getRegionAt(vertices.get(0)));
                    producer.accept(pdv);
                    images.add(pdv.getImageWithLocation());
                }
            }
        }
        return images;
    }

}
