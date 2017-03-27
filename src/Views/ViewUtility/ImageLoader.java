package Views.ViewUtility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class ImageLoader {

    private static HashMap<String, BufferedImage> cachedImages;

    public static BufferedImage getImage(String imageName) {
        return cachedImages.get(imageName);
    }

    static {
        cachedImages = new HashMap<String, BufferedImage>();

        try {
            cachedImages.put("MOUNTAIN", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/mountain.png")));
            cachedImages.put("DESERT", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/desert.png")));
            cachedImages.put("PASTURE", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/pasture.png")));
            cachedImages.put("ROCK", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/rock.png")));
            cachedImages.put("WOODS", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/woods.png")));
            cachedImages.put("SEA", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/sea.png")));

            cachedImages.put("River 1", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river1.png")));
            cachedImages.put("River 2-1", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river2-1.png")));
            cachedImages.put("River 2-2", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river2-2.png")));
            cachedImages.put("River 2-3", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river2-3.png")));
            cachedImages.put("River 3", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river3.png")));

            cachedImages.put("Outline", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/outline.png")));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(ImageLoader.getImage("Mountain"));
    }
}
