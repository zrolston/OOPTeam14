package Gameplay.Views.MainView;

import Gameplay.Views.Drawers.PolygonDrawer;
import Gameplay.Views.Utility.PixelMap;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Willie on 4/14/2017.
 */
public class MapView extends JPanel {

    ILocation[][] map;

    public MapView(){
        map = new HexLocation[10][10];
        for(int i=0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = new HexLocation(i, j);
            }
        }
        setBounds(0,0,PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.println(i+"-"+j);
                PixelPoint center = PixelMap.getMapTileOrigin(map[i][j]);
                PolygonDrawer.drawInMap(g, center);
            }
        }
    }
}
