/**-------------------------------------------------------------------------------------
|	River3Proportions Class: Created by Alejandro Chavez on 4/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the relative graphical proportions of point in Type-3 River.
|   Highly dependent on the graphical elements.
 ---------------------------------------------------------------------------------------*/
package Gameplay.Views.Utility.PolygonProportions;


import Gameplay.Views.Utility.PixelMap;

import java.awt.*;
import java.util.*;

public class River3Proportions {
    public static java.util.List<Point> river, region1, region2;

    static {
        double width = 259, height = 235;
        river = new ArrayList<>();
        river.add(new Point((int) ((113.0 / width) * PixelMap.TILE_FULL_WIDTH), 0));
        river.add(new Point((int) ((76 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((86 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((98 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((120 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((158 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((130 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((167 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((167 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((215 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((189 / height) * PixelMap.TILE_HEIGHT)));

        river.add(new Point((int) ((233 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((158 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((189 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((147 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((180 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((107 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((108 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((90 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((145 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((38 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((145 / width) * PixelMap.TILE_FULL_WIDTH), 0));


        region1 = new ArrayList<>();
        region1.add(new Point((int) ((233 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((158 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((189 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((147 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((180 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((107 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((108 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((90 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((145 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((38 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((145 / width) * PixelMap.TILE_FULL_WIDTH), 0));
        region1.add(new Point(PixelMap.TOP_RIGHT));
        region1.add(new Point(PixelMap.RIGHT));


        region2 = new ArrayList<>();
        region2.add(new Point((int) ((113.0 / width) * PixelMap.TILE_FULL_WIDTH), 0));
        region2.add(new Point((int) ((76 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((86 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((98 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((120 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((158 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((130 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((167 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((167 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((215 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((189 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point(PixelMap.BOTTOM_RIGHT));
        region2.add(new Point(PixelMap.BOTTOM_LEFT));
        region2.add(new Point(PixelMap.LEFT));
        region2.add(new Point(PixelMap.TOP_LEFT));
    }
}
