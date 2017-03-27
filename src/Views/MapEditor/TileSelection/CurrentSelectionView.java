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

    public CurrentSelectionView(Dimension size) {
        setPreferredSize(size);
        setBackground(Color.green);
        setVisible(true);
        drawRiverTiles();
    }


    public void drawRiverTiles() {


        BuildTileFactory factory = new BuildTileFactory();
        TileDrawingVisitor tdv;

        Tile currSelection = factory.createTile("PASTURE",  new int[]{} );

        tdv = new TileDrawingVisitor();
        currSelection.accept( tdv );
        currSelectionImage = tdv.getImage();

    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor( Color.DARK_GRAY );
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = (int)( getWidth() * 0.90 );
        g.drawImage(currSelectionImage, (int)(width * .05), (int)(width * .05), width, width, null);

    }
}
