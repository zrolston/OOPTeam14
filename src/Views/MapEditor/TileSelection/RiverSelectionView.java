package Views.MapEditor.TileSelection;

import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Utility.RiverIterator;
import Model.Utility.TerrainIterator;
import Model.Utility.TileIterator;
import Model.Visitor.TileDrawingVisitor;
import Views.Utility.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class RiverSelectionView extends JPanel {

    private ArrayList<BufferedImage> riverImages = new ArrayList<>();
    private TileIterator terrainIterator = new TerrainIterator();
    private TileIterator riverIterator = terrainIterator.getRiverIterator();

    public RiverSelectionView(Dimension size) {
        setPreferredSize(size);
        setVisible(true);
        drawRiverTiles();
    }

    public void update(int index) {
        terrainIterator.first();
        for(int i = 0; i < index; i++) {
            terrainIterator.next();
        }
        riverIterator = terrainIterator.getRiverIterator();
    }

    public void drawRiverTiles() {

        riverIterator.first();
        for(int i = 0; i < terrainIterator.getSize(); i++) {
            riverImages.add( riverIterator.getImage()  );
            riverIterator.next();
        }

        repaint();
    }



    @Override
    protected void paintComponent(Graphics g) {

        g.setColor( new Color(0xffCABD80) );
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = (int)( getWidth() * 0.90 );
        while(getHeight() / width < riverImages.size()) {
            width -= 5;
        }

        int i = 0;
        for(BufferedImage img : riverImages ) {
            g.drawImage(img, 6, 7  + i * width, width, width, null);
            i++;
        }
    }

}
