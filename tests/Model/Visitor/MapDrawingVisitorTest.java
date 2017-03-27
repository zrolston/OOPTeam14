package Model.Visitor;

import Model.Map.BuildMap;
import Model.Tile.BuildTile;
import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Utility.HexLocation;
import Views.ViewUtility.ImageLoader;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Cameron on 3/26/2017.
 */
public class MapDrawingVisitorTest {
    private int cameraHeight = 2;
    private int cameraWidth = 2;

    @Test
    public void testDefaultImage() throws IOException {
        int addTileRow = 0;
        int addTileColumn = 0;

        BufferedImage testImg = ImageLoader.getImage("DESERT");
        BufferedImage defaultImg = ImageLoader.getImage("OUTLINE");
        byte[] testImageArray = ((DataBufferByte) testImg.getData().getDataBuffer()).getData();
        byte[] defaultImageArray = ((DataBufferByte) defaultImg.getData().getDataBuffer()).getData();

        BuildTileFactory factory = new BuildTileFactory();
        BuildTile t = factory.createTile("DESERT", new int[]{});

        BuildMap map = new BuildMap(10, 10);
        map.addTile(t, new HexLocation(addTileRow, addTileColumn));

        MapDrawingVisitor mdv = new MapDrawingVisitor(new HexLocation(0, 0), new HexLocation(cameraHeight-1, cameraWidth-1));
        map.accept(mdv);
        BufferedImage[][] imgArray = mdv.getImageArray();
        assertEquals(imgArray[0].length, 2);
        assertEquals(imgArray.length, 2);

        for(int i = 0; i < cameraHeight; i++){
            for(int j = 0; j < cameraWidth; j++){
                byte[] currentArray = ((DataBufferByte) imgArray[i][j].getData().getDataBuffer()).getData();
                if(i == addTileRow && j == addTileColumn){
                    assertArrayEquals(testImageArray, currentArray);
                }
                else{
                    assertArrayEquals(defaultImageArray, currentArray);
                }
            }
        }

    }
}
