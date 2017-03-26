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
        setSize(new Dimension(PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Display();
    }
}
