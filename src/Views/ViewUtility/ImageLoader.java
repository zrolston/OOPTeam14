package Views.ViewUtility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.jar.JarFile;

/**
 * Created by Willie on 3/26/2017.
 */
public class ImageLoader {

    private static HashMap<String, BufferedImage> cachedImages;

    public static BufferedImage getImage(String imageName) {
        return cachedImages.get(imageName);
    }

    static {
        cachedImages = new HashMap<String, BufferedImage>();

        BufferedImage test = null;
        try {
            cachedImages.put("Mountain", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/grass_terrain.png")));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(ImageLoader.getImage("grass_terrain"));
    }
}
