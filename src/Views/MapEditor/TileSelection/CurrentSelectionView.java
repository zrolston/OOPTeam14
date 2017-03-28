package Views.MapEditor.TileSelection;

import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Visitor.TileDrawingVisitor;
import Views.Utility.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CurrentSelectionView extends JPanel {

    private static BufferedImage currSelectionImage = null;
    private Tile currSelection = null;

    public CurrentSelectionView(Dimension size) {
        setPreferredSize(size);
        setVisible(true);
        drawCurrentSelection();
    }

    public void update(Tile t) {
        currSelection = t;
        drawCurrentSelection();
    }

    public void drawCurrentSelection() {

        BuildTileFactory factory = new BuildTileFactory();
        TileDrawingVisitor tdv;

        if(currSelection == null)
            currSelection = factory.createTile("MOUNTAIN",  new int[]{} );

        tdv = new TileDrawingVisitor();
        currSelection.accept( tdv );
        currSelectionImage = tdv.getImage();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor( new Color(0xffCABD80)  );
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = (int)( getWidth() * 0.90 );
        g.drawImage(currSelectionImage, (int)(width * .05), (int)(width * .05), width, width, null);

    }

    //Gives global access to currently selected image without breaking encapsulation
    /** Note: It spits out a copy of the currently selected image */
    public static BufferedImage getSelectedTile(){
        return ImageLoader.getDeepCopy(currSelectionImage);
    }
}
