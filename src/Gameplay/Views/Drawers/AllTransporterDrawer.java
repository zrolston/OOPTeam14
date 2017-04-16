package Gameplay.Views.Drawers;

import Gameplay.Model.Iterators.TransporterIterator;
import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Tile.RegionMap;
import Gameplay.Model.Transporters.LandTransporters.Donkey;
import Gameplay.Model.Transporters.Transporter;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Model.Utility.HexaVertex;
import Gameplay.Model.Utility.PlayerID;
import Gameplay.Views.Utility.PixelMap;
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
        List<ImageWithLocation> images = new ArrayList<ImageWithLocation>();
        GameModelFacade gmf = GameModelFacade.getInstance();
        GameMap gm = gmf.debugGetMap();
        GameTile[][] tiles = gm.getTiles();
        TransporterDrawingVisitor tdv = new TransporterDrawingVisitor();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                if (tiles[i][j] == null)
                    continue;
                PixelPoint origin = PixelMap.getMapTileOrigin(new HexLocation(i,j));
                RegionMap regionMap = tiles[i][j].getRegionMap();
                for (List<HexaVertex> vertices : regionMap.getRegionMap().keySet()) {
                    tdv.setOrigin(new PixelPoint(origin.getX() + 20, origin.getY() + 20));
                    TransporterIterator transporters = gmf.getTransporters(regionMap.getRegionAt(vertices.get(0)));
                    for (int k = 0; k < transporters.size(); k++) {
                        transporters.getTransporterAt(k).accept(tdv);
                        images.add(tdv.getImageWithLocation());
                    }
                }
            }
        }
        return images;
    }

}
