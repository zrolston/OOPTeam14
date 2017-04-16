package Gameplay.Views.Drawers;

import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;

/**
 * Created by Willie on 4/16/2017.
 */
public class ThickLine extends Line {

    ThickLine(PixelPoint start, PixelPoint end) {
        super(start, end);
    }

    ThickLine(PixelPoint start, PixelPoint end, Color color) {
        super(start, end, color);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Stroke s = g2.getStroke();
        g2.setStroke(new BasicStroke(15));
        super.draw(g);
        g2.setStroke(s);
    }
}
