package Views.MapEditor.TileSelection;

import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Utility.TerrainIterator;
import Model.Utility.TileIterator;
import Model.Visitor.TileDrawingVisitor;
import Views.Utility.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TerrainSelectionView extends JPanel {

    private ArrayList<BufferedImage> terrainImages = new ArrayList<>();
    private TileIterator terrainIterator = new TerrainIterator();

    public TerrainSelectionView(Dimension size) {
        setPreferredSize(size);
        setVisible(true);

        drawTerrains();
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

        int width = (int)( getWidth() * 0.90 );
        while(getHeight() / width < terrainImages.size()) {
            width -= 5;
        }

        g.setColor( new Color(0xffCABD80)  );
        g.fillRect(0, 0, (int)(getWidth() * .975), getHeight());

        int i = 0;
        for(BufferedImage img : terrainImages ) {
            g.drawImage(img, (int)(width * .05), (int)(width * .05)  + i * width, width, width, null);
            i++;
        }
    }

}
