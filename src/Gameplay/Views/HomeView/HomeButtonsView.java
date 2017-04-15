package Gameplay.Views.HomeView;

import Gameplay.Views.Display;
import MapBuilder.MapEditorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HomeButtonsView extends JPanel {

    private JButton playButton = null;
    private JButton quitButton = null;
    private JButton options = null;
    private Display display;

    public HomeButtonsView(Display display) {

        this.display = display;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));

        playButton = new JButton("START GAME");
        options = new JButton("MAP SELECT");
        quitButton = new JButton("QUIT");

        playButton.setPreferredSize(new Dimension(300, 40));
        options.setPreferredSize(new Dimension(300, 40));
        quitButton.setPreferredSize(new Dimension(300, 40));

        options.setFont(new Font("plain", Font.BOLD, 20));
        options.setBackground( new Color(0xffCABD80) );
        options.setForeground(Color.black);
        options.setOpaque(true);

        playButton.setFont(new Font("plain", Font.BOLD, 20));
        playButton.setBackground( new Color(0xffCABD80) );
        playButton.setForeground(Color.black);
        playButton.setOpaque(true);

        quitButton.setFont(new Font("plain", Font.BOLD, 20));
        quitButton.setBackground( new Color(0xffCABD80) );
        quitButton.setForeground(Color.black);
        quitButton.setOpaque(true);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setCurrScreen( "MAIN_SCREEN" );
            }
        });

        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapEditorSystem mapEditor = new MapEditorSystem(display);
                mapEditor.start();
                mapEditor.setVisible( true );
                display.setVisible( false );
            }
        });

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

}
