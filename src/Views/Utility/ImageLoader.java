package Views.Utility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.HashMap;

public class ImageLoader {

    private static HashMap<String, BufferedImage> cachedImages;

    public static BufferedImage getImage(String imageName) {
        BufferedImage old = cachedImages.get(imageName);
        BufferedImage copy = new BufferedImage(old.getWidth(), old.getHeight(), old.getType());
        Graphics g = copy.getGraphics();
        g.drawImage(old, 0, 0, null);
        g.dispose();
        return copy;
    }

    public static BufferedImage getDefaultImage(){
        return getImage("OUTLINE");
    }

    static {
        cachedImages = new HashMap<String, BufferedImage>();
        try {
            cachedImages.put("DESERT", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/desert.png")));
            cachedImages.put("MOUNTAIN", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/mountain.png")));
            cachedImages.put("OUTLINE", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/outline.png")));
            cachedImages.put("PASTURE", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/pasture.png")));
//            cachedImages.put("RIVER0", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river0.png")));
            cachedImages.put("RIVER1", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river1.png")));
            cachedImages.put("RIVER2-1", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river2-1.png")));
            cachedImages.put("RIVER2-2", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river2-2.png")));
            cachedImages.put("RIVER2-3", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river2-3.png")));
            cachedImages.put("RIVER3", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/river3.png")));
            cachedImages.put("ROCK", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/rock.png")));
            cachedImages.put("SEA", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/sea.png")));
            cachedImages.put("WOODS", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/woods.png")));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(ImageLoader.getImage("Mountain"));
    }


    public static BufferedImage getDeepCopy(BufferedImage image) {
        ColorModel cm = image.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = image.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}
