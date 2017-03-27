package Model.Visitor;

import Model.Map.IViewMap;
import Model.Tile.Tile;
import Model.Utility.ILocation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapDrawingVisitor implements MapVisitor {
    private ILocation topLeft, bottomRight;
    private BufferedImage[][] imageArray;

    public MapDrawingVisitor(ILocation topLeft, ILocation bottomRight){
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public MapDrawingVisitor(ILocation location){
        //TODO implement
    }

    @Override
    public void visitMap(IViewMap map) {
        Tile[][] tiles = map.getTiles(topLeft, bottomRight);
        int height = tiles.length;
        int width = tiles[0].length;
        imageArray = new BufferedImage[width][height];
        /*
        Will return array of tiles in the camera window. There will
        be null tiles.
        */
        TileDrawingVisitor tdv = new TileDrawingVisitor();
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                if(tiles[row][col] == null){
                    try {
                        imageArray[row][col] = ImageIO.read(new File("res/Images/mountain.png"));//TODO imageLoader.getDefaultImage();
//                        System.out.println("i: "+col+" -- j: "+row);
//                        System.out.println(imageArray[row][col]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
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
