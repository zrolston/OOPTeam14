package Views;

import Views.MapEditor.MapEditorView;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Willie on 3/26/2017.
 */

public class Display extends JFrame {
    JLayeredPane mapEditorView;

    public Display() {
        setupFrame();
        mapEditorView = new MapEditorView();
        add(mapEditorView);
    }

    private void setupFrame(){
        getContentPane().setPreferredSize(new Dimension(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
