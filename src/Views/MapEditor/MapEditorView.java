/**-------------------------------------------------------------------------------------
|	MapEditorView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views.MapEditor;

import Views.MapEditor.MapView.MapSubsectionView;
import Views.MapEditor.MapView.MiniMapView;
import Views.Utility.CursorState;
import Views.Utility.PixelMap;
import Views.MapEditor.TileSelection.TileSelectionView;
import Views.Utility.PixelPoint;

import javax.swing.*;
import java.awt.*;

public class MapEditorView extends JLayeredPane {

    private TileSelectionView tileSelectionView;
    private MapSubsectionView mapSubsectionView;
    private MiniMapView miniMapView;
    private ScaleSliderView scaleSliderView;

    public MapEditorView()  {
        setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);

        // Initialize SubViews
        tileSelectionView = new TileSelectionView();
        mapSubsectionView = new MapSubsectionView();
        miniMapView       = new MiniMapView( mapSubsectionView );
        scaleSliderView   = new ScaleSliderView( mapSubsectionView );

        // Add SubViews to Layered Pane
        add(tileSelectionView, new Integer(3));
        add(miniMapView,       new Integer(2));
        add(mapSubsectionView, new Integer(1));
        add(scaleSliderView, new Integer(2));
    }

    public TileSelectionView getTileSelectionView() {
        return tileSelectionView;
    }

    public MapSubsectionView getMapSubsectionView() {
        return mapSubsectionView;
    }

    public MiniMapView getMiniMapView() {
        return miniMapView;
    }

}
