package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ActionSelectionView extends JPanel {

    private BufferedImage background;

    public ActionSelectionView() {
        setLayout(new GridLayout(2, 4));
        setBounds((int)(PixelMap.SCREEN_WIDTH *.225), (int)(PixelMap.SCREEN_HEIGHT * .07), (int)(PixelMap.SCREEN_WIDTH * .55), (int)(PixelMap.SCREEN_HEIGHT * .04));
        setOpaque(false);

        ArrayList<JButton> btns = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        strings.add("buy brick");
        strings.add("destroy wall");
        strings.add("build wall");
        strings.add("build producer");
        strings.add("build road");
        strings.add("build bridge");
        strings.add("produce");
        strings.add("research");



        setLayout( new GridLayout(2, strings.size()/2) );

        for (int i = 0; i < strings.size(); i++) {
            JButton button = new JButton( strings.get(i) );
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setFont(new Font("plain", Font.BOLD, 13));
            btns.add(button);
        }

        for (int i = 0; i < strings.size(); i++) {
            add( btns.get(i) );
        }

        setVisible( true );
        background = ImageLoader.getImage("RESEARCH_BACKGROUND");
        this.setBorder(BorderFactory.createLineBorder(new Color(0x11111111), 1));
    }

    protected void paintComponent(Graphics g) {
        g.setColor( new Color(  0xff000000 ) );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
