package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Willie on 4/14/2017.
 */
public class MapView extends JPanel {

    public MapView() {
        setBounds(0, 0, (int)(PixelMap.SCREEN_WIDTH ), (int)(PixelMap.SCREEN_HEIGHT ));
        setBackground( new Color( 0xff9de7d7 ) );
        setVisible(true);
    }


}
