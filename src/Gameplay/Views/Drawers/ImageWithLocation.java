package Gameplay.Views.Drawers;

import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Willie on 4/16/2017.
 */
public class ImageWithLocation {
    BufferedImage image;
    PixelPoint location;

    public ImageWithLocation(BufferedImage image, PixelPoint location) {
        this.image = image;
        this.location = location;
    }

    public void draw(Graphics g) {
        g.drawImage(image, location.getX() + image.getWidth()/4, location.getY() + image.getHeight()/4, image.getWidth()/2, image.getHeight()/2, null);
    }
}
