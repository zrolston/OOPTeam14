package Model.Visitor;

import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Visitor.TileDrawingVisitor;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

/**
 * Created by Cameron on 3/26/2017.
 */
public class TileDrawingVisitorTest {

    @Test
    public void testDefaultImage() throws IOException {
        BufferedImage testImg = ImageIO.read(new File("res/Images/mountain.png"));
        byte[] testByteArray = ((DataBufferByte) testImg.getData().getDataBuffer()).getData();
        BuildTileFactory factory = new BuildTileFactory();
        Tile t = factory.createTile("ROCK", new int[]{});
        TileDrawingVisitor tdv = new TileDrawingVisitor();
        t.accept(
                tdv
        );
        BufferedImage visitorImage = tdv.getImage();
        byte[] vByteArray = ((DataBufferByte) testImg.getData().getDataBuffer()).getData();
        assertArrayEquals(testByteArray, vByteArray);
    }
    @Test
    public void testFunctionality(){
        BuildTileFactory factory = new BuildTileFactory();
        Tile t = factory.createTile("MOUNTAIN", new int[]{1, 3, 5});
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
