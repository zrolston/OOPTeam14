package Controllers;

import Views.MapEditor.TileSelection.CurrentSelectionView;
import Views.MapEditor.TileSelection.RiverSelectionView;
import Views.MapEditor.TileSelection.TerrainSelectionView;
import Views.MapEditor.TileSelection.TileSelectionView;

import javax.swing.*;
import java.awt.event.*;

public class TileSelectionController implements MouseMotionListener{

    private TileSelectionView tileSelectionView = null;
    private TerrainSelectionView terrainSelectionView = null;
    private RiverSelectionView riverSelectionView = null;
    private CurrentSelectionView currentSelectionView = null;

    public TileSelectionController(TileSelectionView tileSelectionView) {

        this.tileSelectionView = tileSelectionView;
        this.terrainSelectionView = tileSelectionView.getTerrainSelectionView();
        this.riverSelectionView = tileSelectionView.getRiverSelectionView();
        this.currentSelectionView = tileSelectionView.getCurrentSelectionView();

        tileSelectionView.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        double x = (double)(e.getPoint().getX() / tileSelectionView.getWidth());
        double y = (double)(e.getPoint().getY() / tileSelectionView.getHeight());

        // 6 is the number of tiles on display
        int tileIndex = (int)( y / (0.75 / 6) );

        if( y < 0.75 && x < 0.5) {      // click in terrain panel
            riverSelectionView.update( terrainSelectionView.getTerrainString( tileIndex ) );
            currentSelectionView.update( terrainSelectionView.getSelectedTile(tileIndex) );
        }
        else if( y < 0.75 && x > 0.5) { // click in river panel
            currentSelectionView.update( riverSelectionView.getSelectedTile(tileIndex) );
        }
        else if( y > 0.75 ) { // click in current selection panel

        }
    }
}
