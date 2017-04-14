package Gameplay.Model.Utility;

import Gameplay.Model.Tile.GameTile;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.MapParsers.TilePlacement;

public class GameTilePlacement extends TilePlacement {
    private GameTile tile;

    public GameTilePlacement(GameTile tile, HexLocation location) {
        this.tile = tile;
        setLocation(location);
    }

    public GameTile getTile() {
        return tile;
    }
}
