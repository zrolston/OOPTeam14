/**--------------------------------------------------------------------------------------
|	PixelMap Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Maps normal coordinates to pixel coordinates and maintains pixel
|   proportions to automatically adjust to screen size. (Adjusted for the GamePlay Map)
---------------------------------------------------------------------------------------*/

package Gameplay.Views.Utility;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Views.Drawers.TileOutlineDrawer;
import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;

public class PixelMap {

    //Initial Screen Size and Ration (percentage to fullScreen [0.0 - 1.0])
    private static final double SCREEN_RATIO = 0.9;
    private static final int HORIZONTAL_MULTIPLIER = 15;
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    //Dynamic Pixel Constants dependent on Screen Dimensions
    public static final int SCREEN_WIDTH = (int)(screenSize.getWidth()*SCREEN_RATIO), SCREEN_HEIGHT = (int)(screenSize.getHeight()*SCREEN_RATIO);
    public static final int TILE_WIDTH = SCREEN_WIDTH/HORIZONTAL_MULTIPLIER;
    public static final int TILE_HEIGHT = (int)(1.732*TILE_WIDTH);
    public static final int TILE_FULL_WIDTH = TILE_WIDTH*2;

    //Dynamic offsets to generate a HexatileRow
    private static int width_offset = (int)(TILE_WIDTH * 1.5);
    private static int height_offset = (int)(0.5*TILE_HEIGHT);

    //Popular points
    public static final Point TOP_LEFT = new Point(PixelMap.TILE_FULL_WIDTH/4,0);
    public static final Point TOP_RIGHT= new Point(PixelMap.TILE_WIDTH + PixelMap.TILE_FULL_WIDTH/4,0);
    public static final Point RIGHT = new Point(PixelMap.TILE_FULL_WIDTH,PixelMap.TILE_HEIGHT/2);
    public static final Point BOTTOM_RIGHT = new Point(PixelMap.TILE_WIDTH + PixelMap.TILE_FULL_WIDTH/4,PixelMap.TILE_HEIGHT);
    public static final Point BOTTOM_LEFT = new Point(PixelMap.TILE_WIDTH + PixelMap.TILE_FULL_WIDTH/4,PixelMap.TILE_HEIGHT);
    public static final Point LEFT = new Point(0,PixelMap.TILE_HEIGHT/2);


    //Plain Pixel Mapping based on position
    public static PixelPoint getTileCenter(ILocation hexLocation, Camera camera){
        //If odd Column
        if((hexLocation.getCol()%2 == 1) || (hexLocation.getCol()%2 == -1))
            return new PixelPoint(hexLocation.getCol()*width_offset - camera.getOrigin().getX(), hexLocation.getRow()*TILE_HEIGHT - camera.getOrigin().getY());
            //If even Column
        else
            return new PixelPoint(hexLocation.getCol()*width_offset - camera.getOrigin().getX(), hexLocation.getRow()*TILE_HEIGHT-height_offset - camera.getOrigin().getY());
    }

    //Provides Pixel origin of an InGame Tile based on the
    public static PixelPoint getMapTileOrigin(ILocation location){
        Camera camera = Camera.getInstance();
        //If odd Column
        if((location.getCol()%2 == 1) || (location.getCol()%2 == -1))
            return new PixelPoint(location.getCol()*width_offset - camera.getOrigin().getX(), (location.getRow()*TILE_HEIGHT) - camera.getOrigin().getY());
            //If even Column
        else
            return new PixelPoint((location.getCol()*width_offset) - camera.getOrigin().getX(), ((location.getRow()*TILE_HEIGHT + height_offset)) - camera.getOrigin().getY());
    }

    public static HexLocation getHexLocationAtPixelPoint(PixelPoint point) {
        Camera camera = Camera.getInstance();

        double xPosition = (point.getX() + camera.getOrigin().getX());
        double yPosition = (point.getY() + camera.getOrigin().getY());

        HexLocation location = null;

        int column = (int) (xPosition / width_offset);
        if (column % 2 == 0) {
            int row = (int) ((yPosition - height_offset) / TILE_HEIGHT);
            if (yPosition - height_offset < 0)
                row -= 1;
            double xPositionInTile = xPosition - column*width_offset;
            double yPositionInTile = yPosition - height_offset - row*TILE_HEIGHT;
            location = new HexLocation(row, column);
            if (xPositionInTile < (TILE_WIDTH / 2)) {
                if (yPositionInTile < (TILE_HEIGHT / 2)) {
                    if (((TILE_WIDTH / 2) - xPositionInTile) * 1.732 > yPositionInTile)
                        location = new HexLocation(row, column - 1);
                }
                else {
                    if (((TILE_WIDTH / 2) - xPositionInTile) * 1.732 > (TILE_HEIGHT - yPositionInTile))
                        location = new HexLocation(row + 1, column - 1);
                }
            }
        }
        else {
            int row = (int) (yPosition / TILE_HEIGHT);
            if (yPosition < 0)
                row -= 1;
            double xPositionInTile = xPosition - column*width_offset;
            double yPositionInTile = yPosition - row*TILE_HEIGHT;
            location = new HexLocation(row, column);
            if (xPositionInTile < (TILE_WIDTH / 2)) {
                if (yPositionInTile < (TILE_HEIGHT / 2)) {
                    if (((TILE_WIDTH / 2) - xPositionInTile) * 1.732 > yPositionInTile)
                        location = new HexLocation(row - 1, column - 1);
                }
                else {
                    if (((TILE_WIDTH / 2) - xPositionInTile) * 1.732 > (TILE_HEIGHT - yPositionInTile))
                        location = new HexLocation(row, column - 1);
                }
            }
        }

        return location;
    }

    public static boolean isTileVisible(ILocation tileLocation) {
        Camera camera = Camera.getInstance();
        PixelPoint topLeft = getMapTileOrigin(tileLocation);
        PixelPoint bottomRight = new PixelPoint(topLeft.getX() + (TILE_FULL_WIDTH), topLeft.getY() + (TILE_HEIGHT));
        if (((topLeft.getX() > 0) && (topLeft.getX() < SCREEN_WIDTH)) && ((topLeft.getY() > 0) && (topLeft.getY() < SCREEN_HEIGHT)))
            return true;
        else if (((bottomRight.getX() > 0) && (bottomRight.getX() < SCREEN_WIDTH)) && ((bottomRight.getY() > 0)) && (bottomRight.getY() < SCREEN_HEIGHT))
            return true;
        else
            return false;
    }

    //Provides validation to coordinates when overlapping tiles.
    public static boolean tileContains(ILocation tileLocation, PixelPoint point){
        Camera camera = Camera.getInstance();
        PixelPoint center = getTileCenter(tileLocation, camera);
        Polygon hexagon = TileOutlineDrawer.getHexagon(center);
        return hexagon.contains(new Point(point.getX(), point.getY()));
    }
}
