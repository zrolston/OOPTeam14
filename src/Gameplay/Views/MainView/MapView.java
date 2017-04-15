package Gameplay.Views.MainView;

import Gameplay.Views.Drawers.PolygonDrawer;
import Gameplay.Views.Utility.PixelMap;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;
import MapBuilder.Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;


public class MapView extends JPanel {

    ILocation[][] map;
    int size = 50;

    public MapView(){
        map = new HexLocation[size][size];
        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = new HexLocation(i, j);
            }
        }
        setLayout(null);
        setBounds(0,0,PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                PixelPoint center = PixelMap.getMapTileOrigin(map[i][j]);
                Polygon hexaTile = PolygonDrawer.getHexagon(center);
                g.drawPolygon(hexaTile);
            }
        }
    }
}
