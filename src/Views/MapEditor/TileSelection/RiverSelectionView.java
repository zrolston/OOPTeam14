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


//        if(index == riverImages.size() - 1) {
//            riverImages.clear();
//            drawRiverTiles();
//        }

        riverImages.clear();

        terrainIterator.first();
        for(int i = 0; i < index; i++) {
            terrainIterator.next();
        }
        riverIterator = terrainIterator.getRiverIterator();
        drawRiverTiles();
    }

    public void drawRiverTiles() {

        riverIterator.first();
        for(int i = 0; i < terrainIterator.getSize(); i++) {
            riverImages.add( riverIterator.getImage()  );
            riverIterator.next();
        }

        repaint();
    }

    public TileIterator getIterator() {
        return riverIterator;
    }



    @Override
    protected void paintComponent(Graphics g) {
    	((Graphics2D)g).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int width = (int)( getWidth() * 0.90 );
        while(getHeight() / width < riverImages.size()) {
            width -= 5;
        }

        g.setColor( new Color(0xffCABD80)  );
        g.fillRect(0, 0, getWidth(), getHeight());

        int i = 0;
        for(BufferedImage img : riverImages ) {
            g.drawImage(img, (int)(width * .05), (int)(width * .05)  + i * width, width, (int)(width * 0.9), null);
            i++;
        }
    }

}
