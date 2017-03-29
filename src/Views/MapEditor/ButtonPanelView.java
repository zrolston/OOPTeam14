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
        setBounds(PixelMap.SCREEN_WIDTH*15/20, PixelMap.SCREEN_HEIGHT/40, PixelMap.SCREEN_WIDTH*2/10, PixelMap.SCREEN_HEIGHT/18);

        panelBackground = ImageLoader.getImage("PANEL_BACKGROUND");

        JPanel temp = new JPanel( new GridLayout(0, 1) );

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Serif", Font.BOLD, 8));
        saveButton.setBackground( new Color( 0xffCABD80 ) );
        saveButton.setOpaque(false);
        saveButton.setFocusable(false);
        saveButton.addActionListener(new SaveButtonListener());
        saveButton.setOpaque( true );
        this.setOpaque( true );

        JButton loadButton = new JButton("Load");
        loadButton.setBackground( new Color( 0xffCABD80 )  );
        loadButton.setOpaque(false);
        loadButton.setFocusable(false);
        loadButton.addActionListener(new LoadButtonListener());
        loadButton.setFont(new Font("Serif", Font.BOLD, 8));


        JButton validateButton = new JButton(new ImageIcon(ImageLoader.getImage("SAD_CAT")));
//        validateButton.setBackground(new Color( 0xffCABD80 ) );
        validateButton.setOpaque(false);
        validateButton.setFocusable(false);
        validateButton.addActionListener(new ValidateButtonListener(validateButton));

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color( 0xffCABD80 )  );
        clearButton.setOpaque(false);
        clearButton.setFocusable(false);
        clearButton.addActionListener(  new clearButtonListener(clearButton));
        clearButton.setFont(new Font("Serif", Font.BOLD, 8));


        temp.add(saveButton);
        temp.add(loadButton);
        temp.add(clearButton);

        this.add(temp);
        this.add(validateButton);


        this.setBackground( new Color( 0xffCABD80 )   );

        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(panelBackground, 0, 0, (int)(getWidth() * 2), (int)(getHeight() * 2), null);
    }

}
