package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.PixelMap;
import MapBuilder.Model.Utility.HexLocation;
import MapBuilder.Model.Utility.ILocation;

import javax.swing.*;
import java.awt.*;


public class MapView extends JPanel {

    ILocation[][] map;

    public MapView(){
        map = new HexLocation[10][10];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
//                map =
            }
        }




        setBounds(0, 0, (int)(PixelMap.SCREEN_WIDTH ), (int)(PixelMap.SCREEN_HEIGHT ));
        setVisible(true);
    }


    @Override
    public void paint(Graphics g){
        g.setColor(  new Color( 0xff9de7d7 ) );
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
