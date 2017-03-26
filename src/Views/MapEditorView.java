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

public class MapEditorView extends JFrame{

    private TileSelectionView tileSelectionView;
    private MapSubsectionView mapSubsectionView;
    private MiniMapView miniMapView;

    public MapEditorView() {
        setupFrame();
        //Initialize SubViews
        tileSelectionView = new TileSelectionView();
        add(tileSelectionView);
        //Add SubViews to Layered Pane
    }

    private void setupFrame(){
        setLayout(null);
        setSize(new Dimension(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
