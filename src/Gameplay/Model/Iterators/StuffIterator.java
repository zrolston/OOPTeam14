package Gameplay.Model.Iterators;

import Gameplay.Model.Visitors.Carriable;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Utility.TileIterator;

import java.awt.image.BufferedImage;

public interface StuffIterator {
    void first();
    void next();
    Carriable getCurrent();
    int size();
    BufferedImage getImage();

}
