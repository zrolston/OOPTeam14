package Views.MapEditor.TileSelection;

import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Visitor.TileDrawingVisitor;
import Views.Utility.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class RiverSelectionView extends JPanel {

    private static ArrayList< int[] > riverTypes = new ArrayList<>();
    private ArrayList<BufferedImage> riverImages = new ArrayList<>();
    private ArrayList<Tile> tiles = new ArrayList<>();

    private String terrainSelection = "MOUNTAIN";

    public RiverSelectionView(Dimension size) {
        setPreferredSize(size);
        setVisible(true);
        drawRiverTiles();
    }

    public void update(String terrain) {
        terrainSelection = terrain;
        drawRiverTiles();
    }

    public void drawRiverTiles() {

        riverTypes.clear();
        riverImages.clear();
        tiles.clear();

        riverTypes.add( new int[]{} );
        riverTypes.add( new int[]{1} );
        riverTypes.add( new int[]{1, 2} );
        riverTypes.add( new int[]{1, 3} );
        riverTypes.add( new int[]{3, 6} );
        riverTypes.add( new int[]{1, 3, 5} );

        BuildTileFactory factory = new BuildTileFactory();
        TileDrawingVisitor tdv;

        for(int i = 0; i < riverTypes.size(); i++) {
            tiles.add( factory.createTile(terrainSelection,  riverTypes.get( i ) ) );
        }

        for(Tile t : tiles) {
            tdv = new TileDrawingVisitor();
            t.accept( tdv );
            riverImages.add( tdv.getImage() );
        }

    }



    @Override
    protected void paintComponent(Graphics g) {

        g.setColor( new Color(0xffCABD80) );
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = (int)( getWidth() * 0.90 );
        while(getHeight() / width < riverTypes.size()) {
            width -= 5;
        }

        int i = 0;
        for(BufferedImage img : riverImages ) {
            g.drawImage(img, 6, 7  + i * width, width, width, null);
            i++;
        }
    }


    public Tile getSelectedTile( int index ) {
        return tiles.get(index);
    }
    public int[] getRiverType( int index ) {
        return riverTypes.get( index );
    }
}
