package Views.MapEditor.TileSelection;

import Model.Utility.TerrainIterator;
import Model.Utility.TileIterator;
import Views.Utility.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class RiverSelectionView extends JPanel {

    private ArrayList<BufferedImage> riverImages = new ArrayList<>();
    private TileIterator terrainIterator = new TerrainIterator();
    private TileIterator riverIterator = terrainIterator.getRiverIterator();
    private BufferedImage shadow;
    
    public RiverSelectionView(Dimension size) {
        setPreferredSize(size);
        setVisible(true);
        setOpaque(false);
        drawRiverTiles();
        shadow = ImageLoader.getImage("TILE_SHADOW");
    }

    public void update(int index) {
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

        //g.setColor( new Color(0xffCABD80)  );
        //g.fillRect(0, 0, getWidth(), getHeight());

        int i = 0;
        for(BufferedImage img : riverImages ) {
        	g.drawImage(shadow, (int)(width * .05) + 1, (int)(width * .05)  + i * width + 3, width, (int)(width * 0.9), null);
            g.drawImage(img, (int)(width * .05), (int)(width * .05)  + i * width, width, (int)(width * 0.9), null);
            i++;
        }
    }

}
