package MapBuilder.Model.Utility.MapParsers;

import MapBuilder.Model.Utility.HexLocation;

/**
 * Created by jordi on 3/28/2017.
 */
abstract public class TilePlacement{
    private HexLocation location;

    public HexLocation getLocation() {
        return location;
    }

    public void setLocation(HexLocation location){
        this.location = location;
    }
}
