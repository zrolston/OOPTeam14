/**-------------------------------------------------------------------------------------
|	River4Proportions Class: Created by Alejandro Chavez on 4/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the relative graphical proportions of point in Type-4 River.
|   Highly dependent on the graphical elements.
---------------------------------------------------------------------------------------*/
package Gameplay.Views.Utility.PolygonProportions;

import Gameplay.Views.Utility.PixelMap;
import java.awt.*;
import java.util.ArrayList;

public class River4Proportions {
    public static java.util.List<Point> river, region1, region2;

    static {
        double width = 259, height = 235;
        river = new ArrayList<>();
        river.add(new Point((int) ((115 / width) * PixelMap.TILE_FULL_WIDTH), 0));
        river.add(new Point((int) ((117 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((39 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((93 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((87 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((125 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((156 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((113 / width) * PixelMap.TILE_FULL_WIDTH), PixelMap.TILE_HEIGHT));

        river.add(new Point((int) ((141 / width) * PixelMap.TILE_FULL_WIDTH), PixelMap.TILE_HEIGHT));
        river.add(new Point((int) ((161 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((151 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((123 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((88 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((155 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((40 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((146 / width) * PixelMap.TILE_FULL_WIDTH), 0));


        region1 = new ArrayList<>();
        region1.add(new Point((int) ((141 / width) * PixelMap.TILE_FULL_WIDTH), PixelMap.TILE_HEIGHT));
        region1.add(new Point((int) ((161 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((151 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((123 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((88 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((155 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((40 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((146 / width) * PixelMap.TILE_FULL_WIDTH), 0));
        region1.add(new Point(PixelMap.TOP_RIGHT));
        region1.add(new Point(PixelMap.RIGHT));
        region1.add(new Point(PixelMap.BOTTOM_RIGHT));


        region2 = new ArrayList<>();
        region2.add(new Point((int) ((115 / width) * PixelMap.TILE_FULL_WIDTH), 0));
        region2.add(new Point((int) ((117 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((39 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((93 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((87 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((125 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((156 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((113 / width) * PixelMap.TILE_FULL_WIDTH), PixelMap.TILE_HEIGHT));
        region2.add(new Point(PixelMap.BOTTOM_LEFT));
        region2.add(new Point(PixelMap.LEFT));
        region2.add(new Point(PixelMap.TOP_LEFT));

    }
}
