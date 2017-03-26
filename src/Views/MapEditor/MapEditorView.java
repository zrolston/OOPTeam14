/**-------------------------------------------------------------------------------------
|	MapEditorView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views.MapEditor;

import Views.MapEditor.MapView.MapSubsectionView;
import Views.MapEditor.MapView.MiniMapView;
import Views.ViewUtility.PixelMap;
import Views.MapEditor.TileSelection.TileSelectionView;

import javax.swing.*;

public class MapEditorView extends JLayeredPane {

    private TileSelectionView tileSelectionView;
    private MapSubsectionView mapSubsectionView;
    private MiniMapView miniMapView;

    public MapEditorView() {
        setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);

        // Initialize SubViews
        tileSelectionView = new TileSelectionView();
        mapSubsectionView = new MapSubsectionView();

        // Add SubViews to Layered Pane
        add(tileSelectionView, 1);
        add(mapSubsectionView, 2);

        System.out.println(getHeight());
    }

}
