package Model.Utility.MapParsers;

import Model.Tile.BuildTile;
import Model.Tile.Tile;
import Model.Utility.HexLocation;

/**
 * Created by jordi on 3/28/2017.
 */
public class TilePlacement {
    private BuildTile tile;
    private HexLocation location;

    public TilePlacement(BuildTile tile, HexLocation location) {
        this.tile = tile;
        this.location = location;
    }

    public BuildTile getTile() {
        return tile;
    }

    public HexLocation getLocation() {
        return location;
    }
}
