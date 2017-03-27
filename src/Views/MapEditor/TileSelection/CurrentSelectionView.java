package Views.MapEditor.TileSelection;

import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Visitor.TileDrawingVisitor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CurrentSelectionView extends JPanel {

    private BufferedImage currSelectionImage = null;
    private Tile currSelection = null;

    public CurrentSelectionView(Dimension size) {
        setPreferredSize(size);
        setVisible(true);
        drawRiverTiles();
    }

    public void update(Tile t) {
        currSelection = t;
        drawRiverTiles();
    }

    public void drawRiverTiles() {

        BuildTileFactory factory = new BuildTileFactory();
        TileDrawingVisitor tdv;

        if(currSelection == null)
            currSelection = factory.createTile("MOUNTAIN",  new int[]{} );

        tdv = new TileDrawingVisitor();
        currSelection.accept( tdv );
        currSelectionImage = tdv.getImage();

    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor( new Color(0xffCABD80)  );
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = (int)( getWidth() * 0.90 );
        g.drawImage(currSelectionImage, (int)(width * .05), (int)(width * .05), width, width, null);

    }
}
