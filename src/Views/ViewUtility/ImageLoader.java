package Views.ViewUtility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class ImageLoader {

    private static HashMap<String, BufferedImage> cachedImages;

    public static BufferedImage getImage(String imageName) {
        return cachedImages.get(imageName);
    }

    static {
        cachedImages = new HashMap<String, BufferedImage>();

        BufferedImage test = null;
        try {
            cachedImages.put("Mountain", ImageIO.read( new File("res/Images/mountain.png")));
            cachedImages.put("Desert", ImageIO.read(new File("res/Images/desert.png")));
            cachedImages.put("Pasture", ImageIO.read(new File("res/Images/pasture.png")));
            cachedImages.put("Rock", ImageIO.read(new File("res/Images/rock.png")));
            cachedImages.put("Woods", ImageIO.read(new File("res/Images/woods.png")));
            cachedImages.put("Sea", ImageIO.read(new File("res/Images/sea.png")));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(ImageLoader.getImage("Mountain"));
    }
}
