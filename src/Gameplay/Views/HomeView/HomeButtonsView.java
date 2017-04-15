package Gameplay.Views.HomeView;

import Gameplay.Views.Display;
import MapBuilder.MapEditorSystem;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Willie on 4/14/2017.
 */
class HomeButtonsView extends JPanel {

    private JButton playButton = null;
    private JButton quitButton = null;
    private JButton options = null;

    private Display displayFrame = null;

    public HomeButtonsView(Display displayFrame) {

        this.displayFrame = displayFrame;

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
        options.addActionListener(e -> {
		    MapEditorSystem mapEditor = new MapEditorSystem( displayFrame );
		    mapEditor.start();
		    displayFrame.setVisible( false );
		});

        playButton.setFont(new Font("plain", Font.BOLD, 20));
        playButton.setBackground( new Color(0xffCABD80) );
        playButton.setForeground(Color.black);
        playButton.setOpaque(true);

        quitButton.setFont(new Font("plain", Font.BOLD, 20));
        quitButton.setBackground( new Color(0xffCABD80) );
        quitButton.setForeground(Color.black);
        quitButton.setOpaque(true);
        quitButton.addActionListener(e -> System.exit( 0 ));

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
