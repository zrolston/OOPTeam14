package Gameplay.Views.HomeView;

import Gameplay.Views.Display;
import MapBuilder.MapEditorSystem;
import MapBuilder.Views.Utility.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class HomeView extends JPanel {

    private HomeImage homeBackground = null;
    private HomeButtonsView homeButtonsView = null;
    private Display displayFrame = null;

    public HomeView(Display displayFrame) {

        this.displayFrame = displayFrame;
        this.setLayout(new BorderLayout());

        homeBackground = new HomeImage();
        homeButtonsView = new HomeButtonsView(displayFrame);

        this.add(homeBackground, BorderLayout.CENTER);
        this.add(homeButtonsView, BorderLayout.SOUTH);
        this.setBackground( new Color(0xffCABD80) );
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(new Color(0xffCABD80), 3));
    }

    public HomeButtonsView getHomeButtons() {
        return homeButtonsView;
    }

    class HomeImage extends JPanel {

        private BufferedImage background = ImageLoader.getImage("HOME_IMAGE");
        private BufferedImage cover = ImageLoader.getImage("COVER");
        private Graphics2D g2d;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D)(g)).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            ((Graphics2D)(g)).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            // scale image to fill screen
            g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
            
            int height = (int)(getHeight() * 0.85);
        	int width = (544 * height)/854;
        	int x = getWidth() - (int)(width * 1.25);
        	int y = (int)(getHeight() * 0.08);
            g.drawImage(cover, x, y, width, height, null);
            
            
            g.setFont(new Font("phosphate", Font.BOLD, 35));
            g.setColor(new Color(0xff000000));
            g.drawString(" Roads & Boats", 10, 60);
            g.drawString(" COP 4331", 10, 90);

//            g.setFont(new Font("phosphate", Font.BOLD, 26));
//            g.drawString("  Team # 14:", 10, 165);
//            g.drawString("  Randy Brooks,", 10, 200);
//            g.drawString("  Alejandro Chavez,", 10, 230);
//            g.drawString("  Jordi Hernandez,", 10, 260);
//            g.drawString("  Thomas Palmer,", 10, 290);
//            g.drawString("  Zachary Rolston,", 10, 320);
//            g.drawString("  William Wickerson", 10, 350);
        }

    }

}
