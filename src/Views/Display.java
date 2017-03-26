package Views;

import Model.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Willie on 3/26/2017.
 */

public class Display extends JFrame {
    JLayeredPane mapEditorView;

    Display() {
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

    public static void main(String[] args) {
        new Display();
    }
}
