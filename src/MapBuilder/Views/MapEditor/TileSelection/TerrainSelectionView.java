package MapBuilder.Views.MapEditor.TileSelection;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import MapBuilder.Model.Utility.TerrainIterator;
import MapBuilder.Model.Utility.TileIterator;
import MapBuilder.Views.Utility.ImageLoader;

public class TerrainSelectionView extends JPanel {

    private ArrayList<BufferedImage> terrainImages = new ArrayList<>();
    private TileIterator terrainIterator = new TerrainIterator();
    private BufferedImage shadow;
    
    public TerrainSelectionView(Dimension size) {
        setPreferredSize(size);
        setVisible(true);
        setOpaque(false);
        drawTerrains();
        shadow = ImageLoader.getImage("TILE_SHADOW");
    }


    public void drawTerrains() {

        terrainIterator.first();
        for(int i = 0; i < terrainIterator.getSize(); i++) {
            terrainImages.add( terrainIterator.getImage()  );
            terrainIterator.next();
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
    	
    	super.paintComponent(g);
    	((Graphics2D)g).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    	((Graphics2D)g).setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        int width = (int)( getWidth() * 0.90 );
        while(getHeight() / width < terrainImages.size()) {
            width -= 5;
        }

        //g.setColor( new Color(0xffCABD80)  );
        //g.fillRect(0, 0, (int)(getWidth() * .975), getHeight());

        int i = 0;
        for(BufferedImage img : terrainImages ) {
        	g.drawImage(shadow, (int)(width * .05) + 1, (int)(width * .05)  + i * width + 3, width, (int)(width * 0.9), null);
            g.drawImage(img, (int)(width * .05), (int)(width * .05)  + i * width, width, (int)(width * 0.9), null);
            i++;
        }
    }

}
