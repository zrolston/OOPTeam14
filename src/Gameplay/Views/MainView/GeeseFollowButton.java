package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GeeseFollowButton extends JPanel {

    private BufferedImage background;
    JButton geeseButton;

    public GeeseFollowButton() {
        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH * 6.5/40), (int)(PixelMap.SCREEN_HEIGHT * 17/20), PixelMap.SCREEN_WIDTH /7, PixelMap.SCREEN_HEIGHT /12);

        geeseButton = new JButton();
        geeseButton.setText("GEESE ALERT");
        geeseButton.setFont(new Font("plain", Font.BOLD, 13));
        geeseButton.setOpaque(false);
        geeseButton.setVisible( true );

        add(geeseButton, BorderLayout.CENTER);
        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("SCROLL_BACKGROUND");
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
        super.paintComponent(g);
    }

    public void addActionListenerToGeeseButton(ActionListener a) {
        geeseButton.addActionListener( a );
    }
}
