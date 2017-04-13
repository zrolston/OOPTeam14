package MapBuilder.Model.Map;

import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Model.Visitor.MapVisitor;

public interface IViewMap {
    void accept(MapVisitor v);
    Tile[][] getTiles();
    Tile[][] getTiles(ILocation topLeft, ILocation bottomRight);
    Tile getTileAt(ILocation location);
}
