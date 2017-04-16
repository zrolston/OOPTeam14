package Gameplay.Views.Drawers;

import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;

/**
 * Created by Willie on 4/16/2017.
 */
public class ImageWithLocation {
    public Image image;
    PixelPoint location;

    public ImageWithLocation(Image image, PixelPoint location) {
        this.image = image;
        this.location = location;
    }

    public void draw(Graphics g) {
        g.drawImage(image, location.getX(), location.getY(), null);
    }
}
