package MapBuilder.Model.Visitor;

import static org.junit.Assert.assertArrayEquals;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import MapBuilder.Model.Tile.BuildTileFactory;
import MapBuilder.Model.Tile.Tile;
import MapBuilder.Views.Utility.ImageLoader;

/**
 * Created by Cameron on 3/26/2017.
 */
public class TileDrawingVisitorTest {

    @Test
    public void testDefaultImage() throws IOException {
        BufferedImage testImg = ImageLoader.getImage("MOUNTAIN");
        byte[] testByteArray = ((DataBufferByte) testImg.getData().getDataBuffer()).getData();
        BuildTileFactory factory = new BuildTileFactory();
        Tile t = factory.createTile("MOUNTAIN", new int[]{});
        TileDrawingVisitor tdv = new TileDrawingVisitor();
        t.accept(
                tdv
        );
        BufferedImage visitorImage = tdv.getImage();
        byte[] vByteArray = ((DataBufferByte) visitorImage.getData().getDataBuffer()).getData();
        assertArrayEquals(testByteArray, vByteArray);
    }
    @Test
    public void testFunctionality(){
        BuildTileFactory factory = new BuildTileFactory();
        Tile t = factory.createTile("MOUNTAIN", new int[]{2, 4, 6});
        TileDrawingVisitor tdv = new TileDrawingVisitor();
        t.accept(
                tdv
        );
        try {
            ImageIO.write(tdv.getImage(), "png", new java.io.File("res/Images/Tests/testVisit.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
