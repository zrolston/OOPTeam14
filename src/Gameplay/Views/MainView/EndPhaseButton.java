package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class EndPhaseButton extends JPanel {
    private BufferedImage background;
    JButton nextPhase;

    public EndPhaseButton() {
        setLayout(new BorderLayout());
        setBounds((int)(PixelMap.SCREEN_WIDTH *32.0/40), (int)(PixelMap.SCREEN_HEIGHT * 17/20), PixelMap.SCREEN_WIDTH /7, PixelMap.SCREEN_HEIGHT /12);

        nextPhase = new JButton();
        nextPhase.setText("PHASE ADVANCE");
        nextPhase.setFont(new Font("plain", Font.BOLD, 13));
        nextPhase.setOpaque(false);
        nextPhase.setVisible( true );

        add( nextPhase, BorderLayout.CENTER);
        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("SCROLL_BACKGROUND");
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
        super.paintComponent(g);
    }

    public void addActionListenerToEndPhaseButton(ActionListener a) {
        nextPhase.addActionListener( a );
    }

}
