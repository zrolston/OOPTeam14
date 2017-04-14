package Gameplay.Model.Utility;

import Gameplay.Model.Tile.GameTile;
import MapBuilder.Model.Utility.HexLocation;

public class GameTilePlacement {
    private HexLocation location;
    private GameTile tile;

    public GameTilePlacement(GameTile tile, HexLocation location) {
        this.tile = tile;
        this.location = location;
    }


    public GameTile getTile() {
        return tile;
    }

    public HexLocation getLocation() {
        return location;
    }
}
