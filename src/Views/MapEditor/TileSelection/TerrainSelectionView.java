package Views.MapEditor.TileSelection;

import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Visitor.TileDrawingVisitor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TerrainSelectionView extends JPanel {

    private final static String[] terrainTypes = {"DESERT", "MOUNTAIN", "PASTURE", "ROCK", "SEA", "WOODS"};
    private ArrayList<BufferedImage> terrainImages = new ArrayList<>();

    public TerrainSelectionView(Dimension size) {
        setPreferredSize(size);
        setBackground(Color.orange);
        setVisible(true);

        drawTerrains();
    }


    public void drawTerrains() {

        BuildTileFactory factory = new BuildTileFactory();
        TileDrawingVisitor tdv = new TileDrawingVisitor();

        ArrayList<Tile> tiles = new ArrayList<>();
        for(String s : terrainTypes)
            tiles.add( factory.createTile(s, new int[]{}) );

        for(Tile t : tiles) {
            t.accept( tdv );
            terrainImages.add( tdv.getImage() );
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor( Color.orange );
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = (int)( getWidth() * 0.90 );
        int i = 0;
        for(BufferedImage img : terrainImages ) {
            g.drawImage(img, 2, 7  + i * width, width, width, null);
            i++;
        }
    }

}
