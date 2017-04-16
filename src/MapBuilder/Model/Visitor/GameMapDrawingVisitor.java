package MapBuilder.Model.Visitor;

import Gameplay.Model.Visitors.GameTileDrawingVisitor;
import MapBuilder.Model.Map.IViewMap;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Views.Utility.ImageLoader;

import java.awt.image.BufferedImage;

public class GameMapDrawingVisitor implements MapVisitor{

    private BufferedImage[][] imageArray;

    public GameMapDrawingVisitor(){
    }

    public GameMapDrawingVisitor(ILocation location){
        //TODO implement
    }

    @Override
    public void visitMap(IViewMap map) {

        Tile[][] tiles = map.getTiles();
        int height = tiles.length;
        int width = tiles[0].length;

        imageArray = new BufferedImage[width][height];
        /*
        Will return array of tiles in the camera window. There will
        be null tiles.
        */
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                if(tiles[row][col] == null){

                    imageArray[row][col] = ImageLoader.getDefaultImage();
                }
                else{
                    GameTileDrawingVisitor tdv = new GameTileDrawingVisitor();
                    tiles[row][col].accept(tdv);
                    imageArray[row][col] = tdv.getImage();
                }
            }
        }
    }

    public BufferedImage[][] getImageArray(){
        return this.imageArray;
    }
}
