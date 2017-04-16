package Gameplay.Views.Utility;

import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * Created by Ale on 4/16/2017.
 */
public class PolygonUtilityTest {

    static HexLocation[][] map = new HexLocation[10][10];

    static{
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                map[i][j] = new HexLocation(i,j);
            }
        }
    }

    static class TestPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    PixelPoint origin = PixelMap.getMapTileOrigin(new HexLocation(i,j));
                    PixelPoint center = new PixelPoint(origin.getX()-PixelMap.TILE_FULL_WIDTH/2, origin.getY()-PixelMap.TILE_HEIGHT/2);
                    Polygon p = PolygonUtility.getHexagon(center);
                    g.drawPolygon(p);
                }
            }
        }
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Test");
        frame.setLayout(null);
        frame.setBounds(0,0, 1500, 1000);
        frame.setVisible(true);

        TestPanel panel = new TestPanel();
        panel.setVisible(true);
        frame.add(panel);
    }

}