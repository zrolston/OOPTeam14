package MapBuilder.Model.Utility.MapParsers;

import MapBuilder.Model.Tile.BuildTile;
import MapBuilder.Model.Utility.HexLocation;

public class BuildTilePlacement {
    private HexLocation location;
    private BuildTile tile;

    public BuildTilePlacement(BuildTile tile, HexLocation location) {
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
