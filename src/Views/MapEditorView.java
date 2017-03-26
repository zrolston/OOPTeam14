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
        setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);
        //Initialize SubViews
        tileSelectionView = new TileSelectionView();
        mapSubsectionView = new MapSubsectionView();
        add(tileSelectionView, 1);
        add(mapSubsectionView, 2);
        //Add SubViews to Layered Pane

        System.out.println(getHeight());
    }

}
