package Views.MapEditor.TileSelection;

import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Visitor.TileDrawingVisitor;
import Views.Utility.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TerrainSelectionView extends JPanel {

    private final static String[] terrainTypes = {"DESERT", "MOUNTAIN", "PASTURE", "ROCK", "SEA", "WOODS"};
    private ArrayList<BufferedImage> terrainImages = new ArrayList<>();
    private ArrayList<Tile> tiles = new ArrayList<>();

    public TerrainSelectionView(Dimension size) {
        setPreferredSize(size);
        setVisible(true);

        drawTerrains();
    }


    public void drawTerrains() {

        BuildTileFactory factory = new BuildTileFactory();
        TileDrawingVisitor tdv;

        for(String s : terrainTypes)
            tiles.add( factory.createTile(s, new int[]{}) );

        for(Tile t : tiles) {
            tdv = new TileDrawingVisitor();
            t.accept( tdv );
            terrainImages.add( tdv.getImage() );
        }

        repaint();
    }

    public Tile getSelectedTile( int index ) {
        return tiles.get(index);
    }
    public String getTerrainString( int index ) {
        return terrainTypes[index];
    }

    @Override
    protected void paintComponent(Graphics g) {

        int width = (int)( getWidth() * 0.90 );
        while(getHeight() / width < terrainTypes.length) {
            width -= 5;
        }

        g.setColor( new Color(0xffCABD80)  );
        g.fillRect(0, 0, (int)(getWidth() * .95), getHeight());

        int i = 0;
        for(BufferedImage img : terrainImages ) {
            g.drawImage(img, (int)(width * .05), (int)(width * .05)  + i * width, width, width, null);
            i++;
        }
    }

}
