package Views.MapEditor;

import Controllers.ButtonListener.LoadButtonListener;
import Controllers.ButtonListener.SaveButtonListener;
import Controllers.ButtonListener.ValidateButtonListener;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Willie on 3/28/2017.
 */
public class ButtonPanelView extends JPanel {

    public ButtonPanelView() {
        setLayout(new GridLayout(0,3));
        setBounds(PixelMap.SCREEN_WIDTH*15/20, PixelMap.SCREEN_HEIGHT/40, PixelMap.SCREEN_WIDTH*2/10, PixelMap.SCREEN_HEIGHT/20);

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Color.blue);
        saveButton.setOpaque(true);
        saveButton.setFocusable(false);
        saveButton.addActionListener(new SaveButtonListener());

        JButton loadButton = new JButton("Load");
        loadButton.setBackground(Color.yellow);
        loadButton.setOpaque(true);
        loadButton.setFocusable(false);
        loadButton.addActionListener(new LoadButtonListener());

        JButton validateButton = new JButton("Validate");
        validateButton.setBackground(Color.red);
        validateButton.setOpaque(true);
        validateButton.setFocusable(false);
        validateButton.addActionListener(new ValidateButtonListener(validateButton));

        add(saveButton);
        add(loadButton);
        add(validateButton);

        setVisible(true);
    }
}
