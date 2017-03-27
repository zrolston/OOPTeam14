package Model.Utility;

import Views.ViewUtility.ImageLoader;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Cameron on 3/26/2017.
 */
public class TestRotateImage {
    @Test
    public void testRotate(){
        BufferedImage bufferedImage = ImageLoader.getImage("RIVER0");
        BufferedImage reference = ImageLoader.getImage("DESERT");

        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.PI, reference.getWidth() / 2, reference.getHeight() / 2);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        bufferedImage = op.filter(bufferedImage, null);
        try {
            ImageIO.write(bufferedImage, "png", new java.io.File("res/Images/Tests/testRotate.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
