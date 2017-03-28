package Views.MapEditor.TileSelection;

import Model.Terrain.Terrain;
import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Utility.RiverIterator;
import Model.Utility.TerrainIterator;
import Model.Utility.TileIterator;
import Model.Visitor.TileDrawingVisitor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CurrentSelectionView extends JPanel {

    private BufferedImage currSelectionImage = null;
    private TileIterator terrainIterator = new TerrainIterator();
    private TileIterator riverIterator = terrainIterator.getRiverIterator();

    public CurrentSelectionView(Dimension size) {
        setPreferredSize(size);
        setVisible(true);
        drawCurrentSelection();
    }

    public void update( int tileIndex ) {
        ( (RiverIterator)(riverIterator) ).setSelectedTile( tileIndex );
        currSelectionImage = ( (RiverIterator)(riverIterator) ) .getSelectedTileImage();
    }

    public void drawCurrentSelection() {

        currSelectionImage = ( (RiverIterator)(riverIterator) ) .getSelectedTileImage();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor( new Color(0xffCABD80)  );
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = (int)( getWidth() * 0.90 );
        g.drawImage(currSelectionImage, (int)(width * .05), (int)(width * .05), width, width, null);

    }
}
