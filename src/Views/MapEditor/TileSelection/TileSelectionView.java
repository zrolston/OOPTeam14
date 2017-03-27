/**-------------------------------------------------------------------------------------
|	TileSelectionView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views.MapEditor.TileSelection;

import Controllers.MouseListeners.TileSelectionMouseListener;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;

public class TileSelectionView extends JPanel{

    TerrainSelectionView terrainSelectionView;
    RiverSelectionView riverSelectionView;
    CurrentSelectionView currentSelectionView;

    public TileSelectionView(){

        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH * 0.0125), (int)(PixelMap.SCREEN_HEIGHT * 0.025), (int)(PixelMap.SCREEN_WIDTH * 0.155), (int)(PixelMap.SCREEN_HEIGHT * 0.95));

        terrainSelectionView = new TerrainSelectionView(new Dimension(getWidth() / 2 + 1, getHeight() - getWidth()));
        riverSelectionView = new RiverSelectionView(new Dimension(getWidth() / 2 + 1, getHeight() - getWidth()));
        currentSelectionView = new CurrentSelectionView(new Dimension(getWidth(), getWidth()));

        add(terrainSelectionView, BorderLayout.WEST);
        add(riverSelectionView, BorderLayout.EAST);
        add(currentSelectionView, BorderLayout.SOUTH);

        setBorder(BorderFactory.createLineBorder(new Color(0xff000000), 1));

        TileSelectionMouseListener listener = new TileSelectionMouseListener(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);

        setVisible(true);
    }

}
