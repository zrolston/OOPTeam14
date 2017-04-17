package Gameplay.Views.MainView;

import MapBuilder.Views.Utility.ImageLoader;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ActionSelectionView extends JPanel {

    private BufferedImage background;
    private ArrayList<JButton> btns;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;


    public ActionSelectionView(MainView mainView) {
        setLayout(new GridLayout(2, 4));
        setBounds((int)(PixelMap.SCREEN_WIDTH *.225), (int)(PixelMap.SCREEN_HEIGHT * .07), (int)(PixelMap.SCREEN_WIDTH * .55), (int)(PixelMap.SCREEN_HEIGHT * .04));
        setOpaque(false);

        btns = new ArrayList<>();

        b1 = new JButton("buy brick");
        b2 = new JButton("destroy wall");
        b3 = new JButton("build wall");
        b4 = new JButton("build producer");
        b5 = new JButton("build road");
        b6 = new JButton("build bridge");
        b7 = new JButton("produce");
        b8 = new JButton("research");

        btns.add(b1);
        btns.add(b2);
        btns.add(b3);
        btns.add(b4);
        btns.add(b5);
        btns.add(b6);
        btns.add(b7);
        btns.add(b8);

        for (JButton b :
                btns) {
            this.add(b);
        }

        setLayout( new GridLayout(2, btns.size()/2) );
        setVisible( true );
        setOpaque( true );
        setBackground( new Color(0xffF5F5DC));
        background = ImageLoader.getImage("RESEARCH_BACKGROUND");
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
    }

    public ArrayList<JButton> getBtns() {
        return btns;
    }

    public JButton getB1() {
        return b1;
    }

    public JButton getB2() {
        return b2;
    }

    public JButton getB3() {
        return b3;
    }

    public JButton getB4() {
        return b4;
    }

    public JButton getB5() {
        return b5;
    }

    public JButton getB6() {
        return b6;
    }

    public JButton getB7() {
        return b7;
    }

    public JButton getB8() {
        return b8;
    }
}
