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

        try {
            cachedImages.put("DESERT", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/desert.png")));
            cachedImages.put("MOUNTAIN", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/mountain.png")));
            cachedImages.put("OUTLINE", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/outline.png")));
            cachedImages.put("PASTRUE", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/pasture.png")));
            cachedImages.put("RIVER0", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river0.png")));
            cachedImages.put("RIVER1", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river1.png")));
            cachedImages.put("RIVER2", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river2.png")));
            cachedImages.put("RIVER2-2", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river2-2.png")));
            cachedImages.put("RIVER3", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river3.png")));
            cachedImages.put("ROCK", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/rock.png")));
            cachedImages.put("SEA", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/sea.png")));
            cachedImages.put("WOODS", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/woods.png")));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
