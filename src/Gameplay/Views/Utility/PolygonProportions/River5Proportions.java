/**-------------------------------------------------------------------------------------
|	River5Proportions Class: Created by Alejandro Chavez on 4/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the relative graphical proportions of point in Type-5 River.
|   Highly dependent on the graphical elements.
 ---------------------------------------------------------------------------------------*/
package Gameplay.Views.Utility.PolygonProportions;

import Gameplay.Views.Utility.PixelMap;
import java.awt.*;
import java.util.ArrayList;

public class River5Proportions {
    public static java.util.List<Point> river, region1, region2, region3;

    static {
        double width = 258, height = 234;
        river = new ArrayList<>();
        river.add(new Point((int) ((111 / width) * PixelMap.TILE_FULL_WIDTH), 0));
        river.add(new Point((int) ((110 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((89 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((23 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((152 / height) * PixelMap.TILE_HEIGHT)));

        river.add(new Point((int) ((44 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((189 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((128 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((127 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((223 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((187 / height) * PixelMap.TILE_HEIGHT)));

        river.add(new Point((int) ((240 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((158 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((153 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((98 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((145 / width) * PixelMap.TILE_FULL_WIDTH), 0));


        region1 = new ArrayList<>();
        region1.add(new Point((int) ((240 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((158 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((153 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((98 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((145 / width) * PixelMap.TILE_FULL_WIDTH), 0));
        region1.add(new Point(PixelMap.TOP_RIGHT));
        region1.add(new Point(PixelMap.RIGHT));


        region2 = new ArrayList<>();
        region2.add(new Point((int) ((44 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((189 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((128 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((127 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((223 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((187 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point(PixelMap.BOTTOM_RIGHT));
        region2.add(new Point(PixelMap.BOTTOM_LEFT));


        region3 = new ArrayList<>();
        region3.add(new Point((int) ((111 / width) * PixelMap.TILE_FULL_WIDTH), 0));
        region3.add(new Point((int) ((110 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((89 / height) * PixelMap.TILE_HEIGHT)));
        region3.add(new Point((int) ((23 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((152 / height) * PixelMap.TILE_HEIGHT)));
        region3.add(new Point(PixelMap.LEFT));
        region3.add(new Point(PixelMap.TOP_LEFT));
    }
}
