package Model.Utility;

import Model.Tile.Tile;

import java.awt.image.BufferedImage;

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


}
