package Views.MapEditor.TileSelection;

import Model.Terrain.Terrain;
import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Utility.RiverIterator;
import Model.Utility.TerrainIterator;
import Model.Utility.TileIterator;
import Model.Visitor.TileDrawingVisitor;
import Views.Utility.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CurrentSelectionView extends JPanel {
    
    private BufferedImage currSelectionImage = null;
    private TileIterator terrainIterator = new TerrainIterator();
    private TileIterator riverIterator = terrainIterator.getRiverIterator();
    private RiverSelectionView riverSelectionView = null;

    public CurrentSelectionView(Dimension size, RiverSelectionView riverSelectionView) {
        this.riverSelectionView = riverSelectionView;
        setPreferredSize(size);
        setVisible(true);
        drawCurrentSelection();
    }

    public void update( int tileIndex ) {

        this.riverIterator = riverSelectionView.getIterator();

        ( (RiverIterator)(riverIterator) ).setSelectedTile( tileIndex );
        currSelectionImage = ( (RiverIterator)(riverIterator) ) .getSelectedTileImage();


        System.out.println("index: " + tileIndex + "\n" +   ( (RiverIterator)(riverIterator) ).getSelectedTile().toString() );

    }

    public void drawCurrentSelection() {

//        System.out.println(  ( (RiverIterator)(riverIterator) ).getSelectedTile().toString() );
        currSelectionImage = ( (RiverIterator)(riverIterator) ) .getSelectedTileImage();
        repaint();
    }

    public void rotate() {

        ( (RiverIterator)(riverIterator) ) .rotate();
        drawCurrentSelection();
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor( new Color(0xffCABD80)  );
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = (int)( getWidth() * 0.90 );
        g.drawImage(currSelectionImage, (int)(width * .05), (int)(width * .05), width, width, null);

    }
    //Gives global access to currently selected image without breaking encapsulation
    // Note: It spits out a copy of the currently selected image
    public BufferedImage getSelectedTile(){
        return ( (RiverIterator)(riverIterator) ) .getSelectedTileImage();
    }
}
