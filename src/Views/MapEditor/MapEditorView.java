/**-------------------------------------------------------------------------------------
|	MapEditorView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views.MapEditor;

import Views.MapEditor.MapView.MapSubsectionView;
import Views.Utility.PixelMap;
import Views.MapEditor.TileSelection.TileSelectionView;

import javax.swing.*;

public class MapEditorView extends JLayeredPane {

    private TileSelectionView tileSelectionView;
    private MapSubsectionView mapSubsectionView;
    private ScaleSliderView scaleSliderView;
    private ButtonPanelView saveLoadView;

    public MapEditorView()  {
        setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);

        // Initialize SubViews
        tileSelectionView = new TileSelectionView();
        mapSubsectionView = new MapSubsectionView();
        scaleSliderView   = new ScaleSliderView( mapSubsectionView );
        saveLoadView      = new ButtonPanelView();

        // Add SubViews to Layered Pane
        add(tileSelectionView, new Integer(3));
        add(mapSubsectionView, new Integer(1));
        add(scaleSliderView, new Integer(2));
        add(saveLoadView, new Integer(2));
    }

    public TileSelectionView getTileSelectionView() {
        return tileSelectionView;
    }

    public MapSubsectionView getMapSubsectionView() {
        return mapSubsectionView;
    }

}
