package Gameplay.Views.Drawers;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Map.Wall;
import Gameplay.Model.Tile.GameTile;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.Utility.PixelMap;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;
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
        GameMap gm = gmf.getMap();
        Map<GameTile, Map<GameTile, Wall>> wallMap = gmf.getAllWalls();
        for (GameTile tile1 : wallMap.keySet()) {
            for (GameTile tile2 : wallMap.get(tile1).keySet()) {
                Wall wall = wallMap.get(tile1).get(tile2);
                walls.add(getWallImage(tile1, tile2, wall));
            }
        }
        return walls;
    }

    private RotatedImageWithLocation getWallImage(GameTile tile1, GameTile tile2, Wall wall) {
        int rotation = getRotation(tile1, tile2);
        BufferedImage image = getImage(wall);
        PixelPoint origin = getOrigin(tile1, tile2, image.getWidth(), image.getHeight());
        return new RotatedImageWithLocation(image, origin, rotation);
    }

    private BufferedImage getImage(Wall wall) {
        BufferedImage wallImage = null;
        wallImage = ImageLoader.getImage(wall.getPlayerID().getPlayerColor() + "_WALL");
        BufferedImage allWalls = new BufferedImage(wallImage.getWidth(), wallImage.getHeight() * wall.getStrength(), wallImage.getType());
        for (int i = 0; i < wall.getStrength(); i++) {
            Graphics g = allWalls.getGraphics();
            g.drawImage(wallImage, 0, i*wallImage.getHeight(), null);
        }
        return allWalls;
    }

    private int getRotation(GameTile tile1, GameTile tile2) {
        HexLocation location1 = GameModelFacade.getInstance().getMap().getHexLocationOf(tile1);
        HexLocation location2 = GameModelFacade.getInstance().getMap().getHexLocationOf(tile2);

        switch (location1.getIndexOfLocation(location2).getValue()) {
            case 1:
            case 4:
                return 0;
            case 2:
            case 5:
                return 60;
            case 3:
            case 6:
                return -60;
        }

        return 0;
    }

    private PixelPoint getOrigin(GameTile tile1, GameTile tile2, int width, int height) {
        HexLocation location1 = GameModelFacade.getInstance().getMap().getHexLocationOf(tile1);
        HexLocation location2 = GameModelFacade.getInstance().getMap().getHexLocationOf(tile2);
        PixelPoint tileOrigin = PixelMap.getMapTileOrigin(GameModelFacade.getInstance().getMap().getHexLocationOf(tile1));

        int changeX = -width/2;
        int changeY = -height/2;
        switch (location1.getIndexOfLocation(location2).getValue()) {
            case 1:
                changeX += PixelMap.TILE_FULL_WIDTH/2;
                changeY += 3;
                break;
            case 2:
                changeX += PixelMap.TILE_FULL_WIDTH*7/8;
                changeY += PixelMap.TILE_HEIGHT/4 + 4;
                break;
            case 3:
                changeX += PixelMap.TILE_FULL_WIDTH*7/8;
                changeY += PixelMap.TILE_HEIGHT*3/4 + 1;
                break;
            case 4:
                changeX += PixelMap.TILE_FULL_WIDTH/2;
                changeY += PixelMap.TILE_HEIGHT - 2;
                break;
            case 5:
                changeX += PixelMap.TILE_FULL_WIDTH/8;
                changeY += PixelMap.TILE_HEIGHT/4 + 1;
                break;
            case 6:
                changeX += PixelMap.TILE_FULL_WIDTH/8;
                changeY += PixelMap.TILE_HEIGHT*3/4 + 4;
                break;
        }

        return new PixelPoint(tileOrigin.getX() + (int) (changeX * 1.0225), tileOrigin.getY() + (int) (changeY * 1.0225));
    }

}
