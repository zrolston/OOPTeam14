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
    int thickness;

    Line(PixelPoint start, PixelPoint end) {
        this.start = start;
        this.end = end;
        this.color = Color.black;
        this.thickness = 5;
    }

    Line(PixelPoint start, PixelPoint end, Color color, int thickness) {
        this.start = start;
        this.end = end;
        this.color = color;
        this.thickness = thickness;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        ((Graphics2D)(g)).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setStroke(new BasicStroke(thickness));
        g.setColor(color);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
