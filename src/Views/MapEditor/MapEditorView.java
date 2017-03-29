/**-------------------------------------------------------------------------------------
|	MapEditorView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views.MapEditor;

import javax.swing.JLayeredPane;

import Views.MapEditor.MapView.MapSubsectionView;
import Views.MapEditor.TileSelection.TileSelectionView;
import Views.Utility.PixelMap;

public class MapEditorView extends JLayeredPane {

    private TileSelectionView tileSelectionView;
    private MapSubsectionView mapSubsectionView;
    private ScaleSliderView scaleSliderView;
    private ButtonPanelView buttonPanelView;
    private ValidateAndMenuView validateAndMenuView;

    public MapEditorView()  {
        setBounds(0, 0, PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT);

        // Initialize SubViews
        mapSubsectionView = new MapSubsectionView(this);
        tileSelectionView = new TileSelectionView(mapSubsectionView, this);
        scaleSliderView   = new ScaleSliderView(mapSubsectionView);
        buttonPanelView = new ButtonPanelView(mapSubsectionView, this);
        validateAndMenuView = new ValidateAndMenuView(buttonPanelView);

        // Add SubViews to Layered Pane
        add(tileSelectionView, new Integer(3));
        add(mapSubsectionView, new Integer(1));
        add(scaleSliderView, new Integer(2));
        add(buttonPanelView, new Integer(2));
        add(validateAndMenuView, new Integer(2));
    }

    public void updateImages() {
    	validateAndMenuView.checkValidation();
    }
    
    public TileSelectionView getTileSelectionView() {
        return tileSelectionView;
    }

    public MapSubsectionView getMapSubsectionView() {
        return mapSubsectionView;
    }

}
