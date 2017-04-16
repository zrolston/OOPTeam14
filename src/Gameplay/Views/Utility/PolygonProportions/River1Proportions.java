/**-------------------------------------------------------------------------------------
|	River1Proportions Class: Created by Alejandro Chavez on 4/15/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the relative graphical proportions of point in Type-1 River.
|   Highly dependent on the graphical elements.
---------------------------------------------------------------------------------------*/
package Gameplay.Views.Utility.PolygonProportions;

import Gameplay.Views.Utility.PixelMap;
import java.awt.Point;
import java.util.*;

public class River1Proportions {
    public static List<Point> river, region;

    static {
        river = new ArrayList<>();
        river.add(new Point((int)((110.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((4.0/236.0)*PixelMap.TILE_HEIGHT)));
        river.add(new Point((int)((147.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((4.0/236.0)*PixelMap.TILE_HEIGHT)));
        river.add(new Point((int)((149.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((102.0/236.0)*PixelMap.TILE_HEIGHT)));
        river.add(new Point((int)((80.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((151.0/236.0)*PixelMap.TILE_HEIGHT)));
        river.add(new Point((int)((66.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((133.0/236.0)*PixelMap.TILE_HEIGHT)));
        river.add(new Point((int)((112.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((90.0/236.0)*PixelMap.TILE_HEIGHT)));

        region = new ArrayList<>();
        region.add(new Point(PixelMap.TILE_FULL_WIDTH/4,(int)((4.0/236.0)*PixelMap.TILE_HEIGHT)));
        region.add(new Point((int)((110.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((4.0/236.0)*PixelMap.TILE_HEIGHT)));
        region.add(new Point((int)((112.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((90.0/236.0)*PixelMap.TILE_HEIGHT)));
        region.add(new Point((int)((66.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((133.0/236.0)*PixelMap.TILE_HEIGHT)));
        region.add(new Point((int)((80.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((151.0/236.0)*PixelMap.TILE_HEIGHT)));
        region.add(new Point((int)((149.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((102.0/236.0)*PixelMap.TILE_HEIGHT)));
        region.add(new Point((int)((147.0/260.0)* PixelMap.TILE_FULL_WIDTH),(int)((4.0/236.0)*PixelMap.TILE_HEIGHT)));
        region.add(new Point(PixelMap.TILE_WIDTH + PixelMap.TILE_FULL_WIDTH/4,(int)((4.0/236.0)*PixelMap.TILE_HEIGHT)));
        region.add(new Point(PixelMap.TILE_FULL_WIDTH,PixelMap.TILE_HEIGHT/2));
        region.add(new Point(PixelMap.TILE_WIDTH + PixelMap.TILE_FULL_WIDTH/4,PixelMap.TILE_HEIGHT));
        region.add(new Point(PixelMap.TILE_FULL_WIDTH/4,PixelMap.TILE_HEIGHT));
        region.add(new Point(0,PixelMap.TILE_HEIGHT/2));

    }
}
