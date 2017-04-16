package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class WallSelectionView extends JPanel {

    private BufferedImage background;
    private BufferedImage orangeWall;
    private BufferedImage blueWall;

    private BufferedImage outline;
    private BufferedImage hexImage;
    private BufferedImage tileShadow;

    public WallSelectionView() {
        setLayout(new GridLayout(0, 3));
        setBounds((int)(PixelMap.SCREEN_WIDTH *7.0/40), (int)(PixelMap.SCREEN_HEIGHT * .55), (int)(PixelMap.SCREEN_HEIGHT * (0.20)), (int)(PixelMap.SCREEN_HEIGHT * (0.20)));
        setOpaque(false);
        setVisible( true );
        background = ImageLoader.getImage("RESEARCH_BACKGROUND");
        hexImage = ImageLoader.getImage("BLANK_HEX");
        outline = ImageLoader.getImage( "OUTLINE" );
        tileShadow = ImageLoader.getImage("TILE_SHADOW");
        orangeWall = ImageLoader.getImage("ORANGE_WALL");
        blueWall = ImageLoader.getImage("BLUE_WALL");

        ArrayList<JButton> btns = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        strings.add("N");
        strings.add("W");
        strings.add("E");
        strings.add("S");

        for (int i = 0; i < 4; i++) {
            JButton button = new JButton( strings.get(i) );
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setFont(new Font("plain", Font.BOLD, 17));
            btns.add(button);
        }

        int index = 0;
        for (int i = 0; i < 9; i++) {
            if(i == 0 || i == 2 || i == 4 || i == 6 || i == 8) {
                add(new JLabel());
            }
            else {
                add(btns.get(index++));
            }
        }

        this.setBorder(BorderFactory.createLineBorder(new Color(0x11111111), 1));
    }

    protected void paintComponent(Graphics g) {
        int scale = 0; // higher number ---> smaller hex
        g.drawImage(background, 0, 0, (int)(getWidth()), (int)(getHeight()), null);
//        g.drawImage(hexImage, scale, scale, getWidth() - scale * 2, (int)(getHeight()- scale * 2), null);
//        g.drawImage(outline, scale, scale, getWidth() - scale * 2, (int)(getHeight()- scale * 2), null);
//        g.drawImage(outline, scale, scale, getWidth() - scale * 2 + 1, (int)(getHeight()- scale * 2 + 1), null);

        super.paintComponent(g);
    }

}
