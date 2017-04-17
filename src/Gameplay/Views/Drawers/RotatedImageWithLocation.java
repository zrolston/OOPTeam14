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
        super.draw(g);
    }
}
