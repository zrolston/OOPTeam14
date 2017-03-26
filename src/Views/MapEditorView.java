/**-------------------------------------------------------------------------------------
|	MapEditorView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views;

import Model.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;

public class MapEditorView extends JLayeredPane {

    private TileSelectionView tileSelectionView;
    private MapSubsectionView mapSubsectionView;
    private MiniMapView miniMapView;

    public MapEditorView() {
        //Initialize SubViews
        tileSelectionView = new TileSelectionView();
        tileSelectionView.setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        add(tileSelectionView, 1);
        //Add SubViews to Layered Pane
    }

}
