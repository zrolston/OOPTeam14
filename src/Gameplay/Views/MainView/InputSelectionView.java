package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class InputSelectionView extends JPanel {

    private BufferedImage background;

    public InputSelectionView() {
        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH *.225), (int)(PixelMap.SCREEN_HEIGHT * 17/20), (int)(PixelMap.SCREEN_WIDTH * .55), (int)(PixelMap.SCREEN_HEIGHT * .08));
        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("RESEARCH_BACKGROUND");
        this.setBorder(BorderFactory.createLineBorder(new Color(0x11111111), 1));
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);

//        g.setColor( new Color( 0xfffcaebb ) );
//        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
