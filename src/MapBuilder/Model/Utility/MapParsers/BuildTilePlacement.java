package MapBuilder.Model.Utility.MapParsers;

import MapBuilder.Model.Tile.BuildTile;
import MapBuilder.Model.Utility.HexLocation;

public class BuildTilePlacement extends TilePlacement{
    private BuildTile tile;

    public BuildTilePlacement(BuildTile tile, HexLocation location) {
        this.tile = tile;
        setLocation(location);
    }

    public BuildTile getTile() {
        return tile;
    }


}
