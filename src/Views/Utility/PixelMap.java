package Views.Utility;
/**--------------------------------------------------------------------------------------
|	PixelMap Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Maps normal coordinates to pixel coordinates and maintains pixel
|   proportions to automatically adjust to screen size.
---------------------------------------------------------------------------------------*/


import Views.Drawers.TileOutlineDrawer;
import Model.Utility.ILocation;
import java.awt.*;

public class PixelMap {

    //Initial Screen Size and Ration (percentage to fullScreen [0.0 - 1.0])
    private static final double SCREEN_RATIO = 0.8;
    private static final int HORIZONTAL_MULTIPLIER = 20;
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //Dynamic Pixel Constants dependent on Screen Dimensions
    public static final int SCREEN_WIDTH = (int)(screenSize.getWidth()*SCREEN_RATIO), SCREEN_HEIGHT = (int)(screenSize.getHeight()*SCREEN_RATIO);
    //public static final int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = 720;
    public static final int TILE_WIDTH = SCREEN_WIDTH/HORIZONTAL_MULTIPLIER;
    public static final int TILE_HEIGHT = (int)(1.732*TILE_WIDTH);
    public static final int TILE_FULL_WIDTH = TILE_WIDTH*2;

    //Dynamic offsets to generate a HexatileRow
    private static int width_offset = (int)(TILE_WIDTH * 1.5);
    private static int height_offset = (int)(0.5*TILE_HEIGHT);

    //Plain Pixel Mapping based on position
    public static PixelPoint getTileCenter(ILocation hexLocation){
        //If odd Column
        if(hexLocation.getCol()%2 == 1) return new PixelPoint(hexLocation.getCol()*width_offset, hexLocation.getRow()*TILE_HEIGHT);
        //If even Column
        else return new PixelPoint(hexLocation.getCol()*width_offset, hexLocation.getRow()*TILE_HEIGHT-height_offset);
    }

    //Plain Pixel Mapping based on position
    public static PixelPoint getTileCenter(ILocation hexLocation, Camera camera){
        //If odd Column
        if(hexLocation.getCol()%2 == 1)
            return new PixelPoint(hexLocation.getCol()*width_offset - camera.getOrigin().getX(), hexLocation.getRow()*TILE_HEIGHT - camera.getOrigin().getY());
            //If even Column
        else
            return new PixelPoint(hexLocation.getCol()*width_offset - camera.getOrigin().getX(), hexLocation.getRow()*TILE_HEIGHT-height_offset - camera.getOrigin().getY());
    }

    //Provides Pixel origin of an InGame Tile based on the
    public static PixelPoint getMapTileOrigin(ILocation location){
        Camera camera = Camera.getInstance();
        //If odd Column
        if(location.getCol()%2 == 1)
            return new PixelPoint(location.getCol()*width_offset - camera.getOrigin().getX() - TILE_WIDTH, location.getRow()*TILE_HEIGHT - camera.getOrigin().getY() - TILE_HEIGHT/2);
            //If even Column
        else
            return new PixelPoint(location.getCol()*width_offset - camera.getOrigin().getX() - TILE_WIDTH, location.getRow()*TILE_HEIGHT-height_offset - camera.getOrigin().getY() - TILE_HEIGHT/2);
    }


    //Provides validation to coordinates when overlapping tiles.
    public static boolean tileContains(ILocation tileLocation, PixelPoint point){
        PixelPoint center = getTileCenter(tileLocation);
        Polygon hexagon = TileOutlineDrawer.getHexagon(center);
        return hexagon.contains(new Point(point.getX(), point.getY()));
    }
}
