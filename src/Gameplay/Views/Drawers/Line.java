package Gameplay.Views.Drawers;

import MapBuilder.Views.Utility.PixelPoint;

import java.awt.*;

/**
 * Created by Willie on 4/16/2017.
 */
public class Line {

    PixelPoint start;
    PixelPoint end;
    Color color;

    Line(PixelPoint start, PixelPoint end) {
        this.start = start;
        this.end = end;
        this.color = Color.black;
    }

    Line(PixelPoint start, PixelPoint end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
