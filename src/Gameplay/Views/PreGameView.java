package Gameplay.Views;

import MapBuilder.MapEditorSystem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Thomas on 4/13/17.
 */
public class PreGameView extends JPanel {

    private HomeImage homeBackground = null;
    private HomeButtons homeButtons = null;
    private Display display = null;

    public PreGameView( Display display) {

        this.display = display;
        this.setLayout(new BorderLayout());

        homeBackground = new HomeImage();
        homeButtons = new HomeButtons();

        this.add(homeBackground, BorderLayout.CENTER);
        this.add(homeButtons, BorderLayout.SOUTH);
        this.setBackground( new Color(0xffCABD80) );
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(new Color(0xffCABD80), 3));
    }

    public JButton getQuitButton() {
        return homeButtons.getQuitButton();
    }
    public JButton getPlayButton() {
        return homeButtons.getPlayButton();
    }
    public JButton getOptionButton() {
        return homeButtons.getOptionButton();
    }

    public HomeButtons getHomeButtons() {
        return homeButtons;
    }

    class HomeImage extends JPanel {

        private BufferedImage image;
        private Graphics2D g2d;

        public HomeImage()
        {
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/Images/homeScreenImage.png"));
            }
            catch (IOException e) {
            }

        }

        public void paintComponent( Graphics g )
        {
            super.paintComponent( g );

            // scale image to fill screen
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), 0, 0, image.getWidth(),
                    image.getHeight(), null);

            g.setFont(new Font("phosphate",Font.BOLD, 28));
            g.setColor(new Color(0xff000000));
            g.drawString(" Roads & Boats", 10, 60);
            g.drawString(" COP 4331", 10, 90);

            g.setFont(new Font("phosphate",Font.BOLD, 26));
            g.drawString("  Team # 1:", 10, 165);
            g.drawString("  Randy Brooks,", 10, 200);
            g.drawString("  Alejandro Chavez,", 10, 230);
            g.drawString("  Jordi Hernandez,", 10, 260);
            g.drawString("  Thomas Palmer,", 10, 290);
            g.drawString("  Zachary Rolston,", 10, 320);
            g.drawString("  William Wickerson", 10, 350);
        }

        public JButton getQuitButton() {
            return homeButtons.getQuitButton();
        }
        public JButton getPlayButton() {
            return homeButtons.getPlayButton();
        }

    }

    class HomeButtons extends JPanel {

        private JButton playButton = null;
        private JButton quitButton = null;
        private JButton options = null;

        public HomeButtons() {

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0,1));

            playButton = new JButton("START GAME");
            playButton.setPreferredSize(new Dimension(300, 40));
            options = new JButton("MAP EDITOR");
            options.setPreferredSize(new Dimension(300, 40));
            quitButton = new JButton("QUIT");
            quitButton.setPreferredSize(new Dimension(300, 40));

            options.setFont(new Font("plain", Font.BOLD, 20));
            options.setBackground( new Color(0xffCABD80) );
            options.setForeground(Color.black);
            options.setOpaque(true);
            options.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MapEditorSystem mapEditor = new MapEditorSystem(display);
                    mapEditor.start();
                    mapEditor.setVisible( true );
                    display.setVisible( false );
                }
            });

            playButton.setFont(new Font("plain", Font.BOLD, 20));
            playButton.setBackground( new Color(0xffCABD80) );
            playButton.setForeground(Color.black);
            playButton.setOpaque(true);
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    display.setCurrScreen( "MAIN_SCREEN" );
                }
            });



            quitButton.setFont(new Font("plain", Font.BOLD, 20));
            quitButton.setBackground( new Color(0xffCABD80) );
            quitButton.setForeground(Color.black);
            quitButton.setOpaque(true);
            quitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit( 0 );
                }
            });

            panel.setLayout(new GridLayout(0, 3));

            panel.add( playButton  );
            panel.add( options );
            panel.add( quitButton );

            this.add( panel, BorderLayout.CENTER );
            this.setBackground( new Color(0xffCABD80) );
            this.setOpaque(true);
            this.setBorder(BorderFactory.createLineBorder(new Color(0xffCABD80), 3));
        }

        public JButton getQuitButton() {
            return quitButton;
        }
        public JButton getOptionButton() {
            return options;
        }
        public JButton getPlayButton() {
            return playButton;
        }
    }

}
