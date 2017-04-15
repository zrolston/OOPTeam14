package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class WallSelectionView extends JPanel {

    private BufferedImage background;

    public WallSelectionView() {
        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH *7.0/40), (int)(PixelMap.SCREEN_HEIGHT * .55), PixelMap.SCREEN_WIDTH /9, (int)(PixelMap.SCREEN_HEIGHT * (0.20)));
        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("SCROLL_BACKGROUND");
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
        super.paintComponent(g);
    }

}
