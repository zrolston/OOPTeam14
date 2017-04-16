/**-------------------------------------------------------------------------------------
|	River2Proportions Class: Created by Alejandro Chavez on 4/16/2017.
|---------------------------------------------------------------------------------------
|   Description: Maintains the relative graphical proportions of point in Type-2 River.
|   Highly dependent on the graphical elements.
---------------------------------------------------------------------------------------*/
package Gameplay.Views.Utility.PolygonProportions;

import Gameplay.Views.Utility.PixelMap;
import java.awt.Point;
import java.util.*;

public class River2Proportions {
    public static List<Point> river, region1, region2;

    static {
        double width = 258, height = 233;
        river = new ArrayList<>();
        river.add(new Point((int) ((113.0 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((3 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((88 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((80 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((103 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((113 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((171 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((145 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((232 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((125 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((235 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((76 / height) * PixelMap.TILE_HEIGHT)));

        river.add(new Point((int) ((216 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((45 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((202 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((56 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((201 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((108 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((155 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((108 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((124 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((74 / height) * PixelMap.TILE_HEIGHT)));
        river.add(new Point((int) ((148 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((3 / height) * PixelMap.TILE_HEIGHT)));


        region1 = new ArrayList<>();
        region1.add(new Point((int) ((216 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((45 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((202 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((56 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((201 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((108 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((155 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((108 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((124 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((74 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((148 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((3 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point((int) ((148 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((3 / height) * PixelMap.TILE_HEIGHT)));
        region1.add(new Point(PixelMap.TILE_WIDTH + PixelMap.TILE_FULL_WIDTH/4, (int) ((3 / height) * PixelMap.TILE_HEIGHT)));


        region2 = new ArrayList<>();
        region2.add(new Point((int) ((113.0 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((3 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((88 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((80 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((103 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((113 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((171 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((145 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((232 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((125 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point((int) ((235 / width) * PixelMap.TILE_FULL_WIDTH), (int) ((76 / height) * PixelMap.TILE_HEIGHT)));
        region2.add(new Point(PixelMap.TILE_FULL_WIDTH,PixelMap.TILE_HEIGHT/2));
        region2.add(new Point(PixelMap.TILE_WIDTH + PixelMap.TILE_FULL_WIDTH/4,PixelMap.TILE_HEIGHT));
        region2.add(new Point(PixelMap.TILE_FULL_WIDTH/4,PixelMap.TILE_HEIGHT));
        region2.add(new Point(0,PixelMap.TILE_HEIGHT/2));
        region2.add(new Point(PixelMap.TILE_FULL_WIDTH/4,0));

    }
}