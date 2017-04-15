package MapBuilder.Views.Utility;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageLoader {

    private static HashMap<String, BufferedImage> cachedImages;

    public static BufferedImage getImage(String imageName) {
//        BufferedImage old = cachedImages.get(imageName);
//        BufferedImage copy = new BufferedImage(old.getWidth(), old.getHeight(), old.getType());
//        Graphics g = copy.getGraphics();
//        g.drawImage(old, 0, 0, null);
//        g.dispose();
        return cachedImages.get(imageName);
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
            cachedImages.put("TILE_SHADOW", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/tileShadow.png")));
            cachedImages.put("BACKGROUND", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/GUI/background.jpg")));
            cachedImages.put("PANEL_BACKGROUND", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/GUI/panelBackground.png")));
            cachedImages.put("SCROLL_BACKGROUND", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/GUI/scrollBackground.png")));     
            cachedImages.put("HAPPY_CAT", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/happyCat.png")));
            cachedImages.put("SAD_CAT", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/sadCat.png")));  
            cachedImages.put("HAMBURGER", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/hamburger.png")));
            cachedImages.put("BOMB", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/bomb.png")));
            cachedImages.put("SAVE", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/save.png")));  
            cachedImages.put("LOAD", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/load.png")));   
            cachedImages.put("WONDER", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/wonder.png")));  
            cachedImages.put("WONDER_BACKGROUND", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/wonderBackground.png"))); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getDeepCopy(BufferedImage image) {
        ColorModel cm = image.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = image.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}
