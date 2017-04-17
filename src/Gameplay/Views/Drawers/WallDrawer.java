package Gameplay.Views.Drawers;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Map.Wall;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Utility.GameModelFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Willie on 4/17/2017.
 */
public class WallDrawer {

    public List<RotatedImageWithLocation> getAllWalls() {
        List<RotatedImageWithLocation> walls = new ArrayList<RotatedImageWithLocation>();
        GameModelFacade gmf = GameModelFacade.getInstance();
        GameMap gm = gmf.debugGetMap();
        Map<GameTile, Map<GameTile, Wall>> wallMap = gmf.getAllWalls();
        for (GameTile tile1 : wallMap.keySet()) {
            for (GameTile tile2 : wallMap.get(tile1).keySet()) {
                Wall wall = wallMap.get(tile1).get(tile2);
            }
        }
        return walls;
    }

    private RotatedImageWithLocation getWallImage() {
        return null;
    }

}
