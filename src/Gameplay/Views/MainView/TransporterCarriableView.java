package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TransporterCarriableView extends JPanel {

    private BufferedImage background;

    public TransporterCarriableView() {
        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH * (1 - 32.0/40 - 1.0/7)), (int)(PixelMap.SCREEN_HEIGHT * .05), PixelMap.SCREEN_WIDTH /7, (int)(PixelMap.SCREEN_HEIGHT * (17.0/20 + 1.0/12 - .05)));


        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("SCROLL_BACKGROUND");
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
        super.paintComponent(g);
    }

}
