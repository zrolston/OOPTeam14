package Views;

import Controllers.KeyboardListeners.EditorKeyboardListener;
import Model.ModelFacade;
import Views.MapEditor.MapEditorView;
import Views.MapEditor.MapView.MapSubsectionView;
import Views.MapEditor.TileSelection.TileSelectionView;
import Views.Utility.PixelMap;
import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    MapEditorView mapEditorView;
    MapSubsectionView  mapSubsectionView;

    public Display() {
        setupFrame();
        mapEditorView = new MapEditorView();
        addKeyListener(new EditorKeyboardListener(ModelFacade.getInstance()));
        add(mapEditorView);
        mapSubsectionView = mapEditorView.getMapSubsectionView();

        EditorKeyboardListener listener = new EditorKeyboardListener(ModelFacade.getInstance());
        listener.setComponent(this);
        addKeyListener(listener);
    }

    private void setupFrame(){
        getContentPane().setPreferredSize(new Dimension(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public TileSelectionView getTileSelectionView() {
        return mapEditorView.getTileSelectionView();
    }
    public void updateMap(){
        mapSubsectionView.repaint();
    }

}
