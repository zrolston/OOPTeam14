/**-------------------------------------------------------------------------------------
|	MiniMapView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: Minimized representation of the map. Weill most likely run on a different
|   Thread than the main map rendering to evade conflicts.
---------------------------------------------------------------------------------------*/
package Views.MapEditor.MapView;

import Views.Utility.PixelMap;
import javax.swing.*;
import java.awt.*;

public class MiniMapView extends JPanel {

    public MiniMapView() {
        double width  = 0.75;
        double height = 0.75;
        setBounds((int)(PixelMap.SCREEN_WIDTH * width), (int)(PixelMap.SCREEN_HEIGHT * height), (int)(PixelMap.SCREEN_WIDTH * (1 - width - 0.0125)), (int)(PixelMap.SCREEN_HEIGHT * (1 - height - 0.0125*2)));
        setBackground(Color.orange);
        setBorder(BorderFactory.createLineBorder(new Color(0xff000000), 1));
        setVisible(true);
    }
}
