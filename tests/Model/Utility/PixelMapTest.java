package Model.Utility;

import Views.Utility.PixelMap;
import Views.Utility.PixelPoint;
import org.junit.Test;

/**
 * Created by Ale on 3/25/2017.
 */
public class PixelMapTest {

    @Test
    public void testGetTileCenter(){
        PixelPoint point1 = PixelMap.getTileCenter(new HexLocation(1, 0));
        PixelPoint point2 = PixelMap.getTileCenter(new HexLocation(1, 1));
        PixelPoint point3 = PixelMap.getTileCenter(new HexLocation(1, 2));
        assert(new PixelPoint(0, (PixelMap.TILE_HEIGHT/2)).equals(point1));
        assert(new PixelPoint((int)(PixelMap.TILE_WIDTH*1.5), (PixelMap.TILE_HEIGHT/2)*2).equals(point2));
        assert(new PixelPoint(2*(int)(PixelMap.TILE_WIDTH*1.5), (PixelMap.TILE_HEIGHT/2)).equals(point3));
    }
}