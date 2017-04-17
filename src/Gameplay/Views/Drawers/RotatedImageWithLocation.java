package Gameplay.Views.Drawers;

import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Willie on 4/17/2017.
 */
public class RotatedImageWithLocation extends ImageWithLocation {

    int rotation;

    public RotatedImageWithLocation(BufferedImage image, PixelPoint location, int rotation) {
        super(image, location);
        this.rotation = rotation;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(Math.toRadians(rotation), location.getX() + image.getWidth()/2, location.getY() + image.getHeight()/2);
        g2.drawImage(image, location.getX(), location.getY(), null);
        g2.dispose();
    }
}
