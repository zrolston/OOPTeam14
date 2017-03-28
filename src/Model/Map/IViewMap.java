package Model.Map;

import Model.Tile.Tile;
import Model.Utility.HexaIndex;
import Model.Utility.ILocation;
import Model.Visitor.MapVisitor;

public interface IViewMap {
    void accept(MapVisitor v);
    Tile[][] getTiles();
    Tile[][] getTiles(ILocation topLeft, ILocation bottomRight);
    Tile getTileAt(ILocation location);
}
