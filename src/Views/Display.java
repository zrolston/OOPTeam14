package Views;

import Views.MapEditor.MapEditorView;
import Views.ViewUtility.PixelMap;

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
        setLayout(null);
        setResizable(false);
        getContentPane().setPreferredSize(new Dimension(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
