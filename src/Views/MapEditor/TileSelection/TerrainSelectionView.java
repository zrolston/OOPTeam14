package Views.MapEditor.TileSelection;

import Model.Tile.BuildTileFactory;
import Model.Tile.Tile;
import Model.Visitor.TileDrawingVisitor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TerrainSelectionView extends JPanel {

    public TerrainSelectionView(Dimension size) {
        setPreferredSize(size);
        setBackground(Color.orange);
        setVisible(true);

        drawTerrains();
    }


    public void drawTerrains() {

        BuildTileFactory factory = new BuildTileFactory();
        TileDrawingVisitor tdv = new TileDrawingVisitor();

        Tile rockTile = factory.createTile("ROCK", new int[]{});
        rockTile.accept( tdv );
        BufferedImage rockTileImage = tdv.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

     //   g.setColor( Color.orange );
     //   g.fillRect(0, 0, getWidth(), getHeight());
     //   g.drawImage(image, 0, 0, null);


    }



}
