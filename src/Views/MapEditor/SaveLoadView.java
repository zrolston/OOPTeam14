package Views.MapEditor;

import Controllers.ButtonListener.LoadButtonListener;
import Controllers.ButtonListener.SaveButtonListener;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Willie on 3/28/2017.
 */
public class SaveLoadView extends JPanel {

    public SaveLoadView() {
        setLayout(new GridLayout(0,2));

        int width = (int)(1.5 * PixelMap.SCREEN_WIDTH / 10);
        int height = PixelMap.SCREEN_HEIGHT / 20;

        setBounds(PixelMap.SCREEN_WIDTH*8/10, PixelMap.SCREEN_HEIGHT/40, width, height);

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Color.blue);
        saveButton.setOpaque(true);
        saveButton.setFocusable(false);
        saveButton.addActionListener(new SaveButtonListener());

        JButton loadButton = new JButton("load");
        loadButton.setBackground(Color.green);
        loadButton.setOpaque(true);
        loadButton.setFocusable(false);
        loadButton.addActionListener(new LoadButtonListener());

        add(saveButton);
        add(loadButton);

        setVisible(true);
    }
}
