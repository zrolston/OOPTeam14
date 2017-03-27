package Views;

import Controllers.KeyboardListeners.EditorKeyboardListener;
import Model.ModelFacade;
import Views.MapEditor.MapEditorView;
import Views.MapEditor.MapView.MapSubsectionView;
import Views.Utility.PixelMap;
import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    MapEditorView mapEditorView;
    MapSubsectionView mapSubsectionView;

    public Display() {
        setupFrame();
        mapEditorView = new MapEditorView();
        add(mapEditorView);
        mapSubsectionView = mapEditorView.getMapSubsectionView();
        addKeyListener(new EditorKeyboardListener(new ModelFacade(null)));
    }

    private void setupFrame(){
        getContentPane().setPreferredSize(new Dimension(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void updateMap(){
        mapSubsectionView.repaint();
    }

}
