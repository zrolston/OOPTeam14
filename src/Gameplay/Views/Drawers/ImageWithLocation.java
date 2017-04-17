package Gameplay.Views.Drawers;

import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Willie on 4/16/2017.
 */
public class ImageWithLocation {
    protected BufferedImage image;
    protected PixelPoint location;

    public ImageWithLocation(BufferedImage image, PixelPoint location) {
        this.image = image;
        this.location = location;
    }

    public void draw(Graphics g) {
        g.drawImage(image, location.getX(), location.getY(), null);
    }
}
