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
        JarFile jarFile = null;
//        try {
//            //testFile = new File(ImageLoader.class.getResource("/Images"));
//            String resourcePath = ImageLoader.class.getResource("/Images").getPath();
//            String jarFilePath = resourcePath.substring();
//            System.out.println(jarFilePath);
//            jarFile = new JarFile(resourcePath);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (testFile != null) {
//            System.out.println(testFile);
//            //System.out.println(testFile.isDirectory());
//        }

        BufferedImage test = null;
        try {
            cachedImages.put("Mountain", ImageIO.read(ImageLoader.class.getResourceAsStream("/Images/Mountain.png")));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //ImageIcon test = new ImageIcon("res/Images/Mountain.png");
        cachedImages.put("test", test);
    }

    public static void main(String[] args) {
        System.out.println(ImageLoader.getImage("Mountain"));
    }
}
