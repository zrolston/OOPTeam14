/**-------------------------------------------------------------------------------------
|	TileSelectionView Class: Created by Alejandro Chavez on 3/26/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/
package Views.MapEditor.TileSelection;

import Controllers.MouseListeners.TileSelectionMouseListener;
import Views.Utility.ImageLoader;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TileSelectionView extends JPanel{

    TerrainSelectionView terrainSelectionView;
    RiverSelectionView riverSelectionView;
    CurrentSelectionView currentSelectionView;
    BufferedImage panelBackground;
    
    public TileSelectionView(){

        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH * 0.0125), (int)(PixelMap.SCREEN_HEIGHT * 0.025), (int)(PixelMap.SCREEN_WIDTH * (0.0125 + 0.155)), (int)(PixelMap.SCREEN_HEIGHT * 0.95));

        terrainSelectionView = new TerrainSelectionView(new Dimension(getWidth() / 2 + 1, getHeight() - getWidth()));
        riverSelectionView = new RiverSelectionView(new Dimension(getWidth() / 2 + 1, getHeight() - getWidth()));
        currentSelectionView = new CurrentSelectionView(new Dimension(getWidth(), getWidth()), riverSelectionView);
        panelBackground = ImageLoader.getImage("PANEL_BACKGROUND");

        add(terrainSelectionView, BorderLayout.WEST);
        add(riverSelectionView, BorderLayout.EAST);
        add(currentSelectionView, BorderLayout.SOUTH);
        
        
        TileSelectionMouseListener listener = new TileSelectionMouseListener(this, currentSelectionView);
        addMouseListener(listener);
        addMouseMotionListener(listener);

        setVisible(true);
    }


    public TerrainSelectionView getTerrainSelectionView() {
        return terrainSelectionView;
    }
    public RiverSelectionView getRiverSelectionView() {
        return riverSelectionView;
    }
    public CurrentSelectionView getCurrentSelectionView() {
        return currentSelectionView;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.drawImage(panelBackground, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight() * 1.032), null);
    	int recWidth = (int)(getWidth() * 0.97);
    	int recHeight = (int)(getHeight() * 0.7);
    	g.drawRect(0, 0, recWidth, recHeight);
    	g.drawLine(recWidth/2, 0, recWidth/2, recHeight);
    	g.drawLine(0, recHeight, recWidth, recHeight);
    }
}
