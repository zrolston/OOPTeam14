package MapBuilder.Model.Utility;

import java.awt.image.BufferedImage;

import MapBuilder.Model.Tile.Tile;

/**
 * Created by Cameron on 3/27/2017.
 */
public interface TileIterator {

    void first();
    void next();
    Tile current();
    BufferedImage getImage();
    void rotate();
    TileIterator getRiverIterator();
    int getSize();
    void setSelectedTile(int index);
    Tile getSelectedTile();
    BufferedImage getSelectedTileImage();
}
