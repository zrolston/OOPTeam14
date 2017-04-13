package MapBuilder.Views.MapEditor.TileSelection;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import MapBuilder.Model.Tile.Tile;
import MapBuilder.Model.Utility.TerrainIterator;
import MapBuilder.Model.Utility.TileIterator;
import MapBuilder.Views.Utility.ImageLoader;

public class CurrentSelectionView extends JPanel {
    
    private BufferedImage currSelectionImage = null;
    private TileIterator terrainIterator = new TerrainIterator();
    private TileIterator riverIterator = terrainIterator.getRiverIterator();
    private RiverSelectionView riverSelectionView = null;
    private BufferedImage shadow;
    
    public CurrentSelectionView(Dimension size, RiverSelectionView riverSelectionView) {
        this.riverSelectionView = riverSelectionView;
        setPreferredSize(size);
        setVisible(true);
        setOpaque(false);
        drawCurrentSelection();
        shadow = ImageLoader.getImage("TILE_SHADOW");
    }

    public void update( int tileIndex ) {

        this.riverIterator = riverSelectionView.getIterator();
        if (tileIndex < riverIterator.getSize()){
            riverIterator.setSelectedTile( tileIndex );
            currSelectionImage = riverIterator.getSelectedTileImage();
        }

    }

    public void drawCurrentSelection() {

        currSelectionImage = riverIterator.getSelectedTileImage();
        repaint();
    }

    public void rotate() {

        riverIterator.rotate();
        drawCurrentSelection();
    }

    @Override
    protected void paintComponent(Graphics g) {
    	((Graphics2D)g).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int width = (int)( getWidth() * 0.90 );
        g.drawImage(shadow, (int)(width * .05), (int)(width * .05) + 13, width, (int)(width * 0.9), null);
        g.drawImage(currSelectionImage, (int)(width * .05) - 3, (int)(width * .05) + 10, width, (int)(width * 0.9), null);
    }
    //Gives global access to currently selected image without breaking encapsulation
    // Note: It spits out a copy of the currently selected image
    public BufferedImage getSelectedTileImage(){
        return riverIterator.getSelectedTileImage();
    }

    public Tile getSelectedTile(){
        return riverIterator.getSelectedTile();
    }
}
