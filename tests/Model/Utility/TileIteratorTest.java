package Model.Utility;

/**
 * Created by Cameron on 3/27/2017.
 */

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TileIteratorTest {
    @Test
    public void testBasic(){
        TileIterator iter1 = new TerrainIterator();
        BufferedImage test;
        iter1.first();
        test = iter1.getImage();
        TileIterator iter2 = iter1.getRiverIterator();
        iter2.first();
        test = iter2.getImage();
        ((RiverIterator)iter2).setSelectedTile(1);
        test = ((RiverIterator) iter2).getSelectedTileImage();
        iter2.rotate();
        test = ((RiverIterator) iter2).getSelectedTileImage();

        iter2.next();
        iter2.next();
        test = iter2.getImage();
        iter2.next();
        test = iter2.getImage();
        iter2.next();
        test = iter2.getImage();
        iter2.next();
        test = iter2.getImage();
        iter2.next();
        test = iter2.getImage();
    }
}
