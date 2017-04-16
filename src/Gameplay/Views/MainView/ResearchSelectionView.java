package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ResearchSelectionView extends JPanel {

    private BufferedImage background;

    public ResearchSelectionView() {
        setLayout(new GridLayout(0, 1));
        setBounds((int)(PixelMap.SCREEN_WIDTH *27.0/40), (int)(PixelMap.SCREEN_HEIGHT * .25), PixelMap.SCREEN_WIDTH /7, (int)(PixelMap.SCREEN_HEIGHT * (0.25)));

        ArrayList<JButton> btns = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        strings.add("rowing");
        strings.add("trucking");
        strings.add("shipping");
        strings.add("drilling");
        strings.add("specialisation");
        strings.add("enlargement");
        strings.add("new shafts");
        strings.add("bright idea");

        for (int i = 0; i < strings.size(); i++) {
            JButton button = new JButton( strings.get(i) );
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setFont(new Font("plain", Font.BOLD, 17));
            button.setForeground( new Color( 0xff786767 ) );
            btns.add(button);
        }

        JLabel researchLabel = new JLabel("Research");
        researchLabel.setFont(new Font("plain", Font.BOLD, 20));
        researchLabel.setForeground( new Color( 0xff786767 ) );

        add(researchLabel);

        for (int i = 0; i < strings.size(); i++) {
            add( btns.get(i) );
        }

        setVisible( true );
        background = ImageLoader.getImage("RESEARCH_BACKGROUND");
        setBackground( new Color( 0xffF5F5DC ) );
        setOpaque( true );
        this.setBorder(BorderFactory.createLineBorder(new Color(0x11111111), 1));
    }

    protected void paintComponent(Graphics g) {
//        g.drawImage(background, 0, 0, (int)(getWidth() * 1.145), (int)(getHeight()), null);
        super.paintComponent(g);
    }



}
