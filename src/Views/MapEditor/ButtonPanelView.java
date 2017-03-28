package Views.MapEditor;

import Controllers.ButtonListener.LoadButtonListener;
import Controllers.ButtonListener.SaveButtonListener;
import Controllers.ButtonListener.ValidateButtonListener;
import Controllers.ButtonListener.clearButtonListener;
import Views.Utility.ImageLoader;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Willie on 3/28/2017.
 */
public class ButtonPanelView extends JPanel {

    BufferedImage panelBackground = null;

    public ButtonPanelView() {
        setLayout(new GridLayout(0,2));
        setBounds(PixelMap.SCREEN_WIDTH*15/20, PixelMap.SCREEN_HEIGHT/40, PixelMap.SCREEN_WIDTH*2/10, PixelMap.SCREEN_HEIGHT/20);

        panelBackground = ImageLoader.getImage("PANEL_BACKGROUND");

        JButton saveButton = new JButton("Save");
        saveButton.setBackground( new Color( 0xffCABD80 ) );
        saveButton.setOpaque(true);
        saveButton.setFocusable(false);
        saveButton.addActionListener(new SaveButtonListener());
        saveButton.setOpaque( true );
        this.setOpaque( true );

        JButton loadButton = new JButton("Load");
        loadButton.setBackground( new Color( 0xffCABD80 )  );
        loadButton.setOpaque(true);
        loadButton.setFocusable(false);
        loadButton.addActionListener(new LoadButtonListener());

        JButton validateButton = new JButton("Validate");
        validateButton.setBackground(new Color( 0xffCABD80 )  );
        validateButton.setOpaque(true);
        validateButton.setFocusable(false);
        validateButton.addActionListener(new ValidateButtonListener(validateButton));

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color( 0xffCABD80 )  );
        clearButton.setOpaque(true);
        clearButton.setFocusable(false);
        clearButton.addActionListener(  new clearButtonListener(clearButton));

        add(saveButton);
        add(loadButton);
        add(validateButton);
        add(clearButton);

        this.setBackground( new Color( 0xffCABD80 )   );

        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(panelBackground, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight() * 1.032), null);
        int recWidth = (int)(getWidth() * 0.97);
        int recHeight = (int)(getHeight() * 0.71);
        g.drawRect(0, 0, recWidth, (int)(getHeight() * 0.99));
    }

}
