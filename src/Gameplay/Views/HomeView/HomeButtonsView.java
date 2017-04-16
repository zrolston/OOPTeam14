package Gameplay.Views.HomeView;

import Gameplay.Model.Map.GameMap;
import Gameplay.Model.Utility.GameMapDaveBuilder;
import Gameplay.Model.Utility.GameModelFacade;
import Gameplay.Views.Display;
import MapBuilder.MapEditorSystem;
import MapBuilder.Model.Map.BuildMap;
import MapBuilder.Model.ModelFacade;
import MapBuilder.Model.Utility.FileIO;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
        options.addActionListener(e -> {
		    MapEditorSystem mapEditor = new MapEditorSystem( display );
		    mapEditor.start();
            display.setVisible( false );
		});

        playButton.setFont(new Font("plain", Font.BOLD, 20));
        playButton.setBackground( new Color(0xffCABD80) );
        playButton.setForeground(Color.black);
        playButton.setOpaque(true);

        quitButton.setFont(new Font("plain", Font.BOLD, 20));
        quitButton.setBackground( new Color(0xffCABD80) );
        quitButton.setForeground(Color.black);
        quitButton.setOpaque(true);

        // START GAME
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Load Map");
                chooser.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        if (file.isDirectory()) {
                            return true;
                        } else {
                            String filename = file.getName().toLowerCase();
                            return filename.endsWith(".dave");
                        }
                    }

                    @Override
                    public String getDescription() {
                        return "Dave Map File (*.dave)";
                    }
                });
                chooser.setCurrentDirectory(new File(FileIO.mapsDir));
                chooser.setVisible(true);
                String path= null;
//                if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
//
////                     path = chooser.getSelectedFile().getAbsolutePath();
////                     GameModelFacade.initialize();
////                     GameModelFacade.getInstance().loadMap(path);
////                     mapSubsectionView.updateCachedImages(GameMapDaveBuilder.);
////                     mapEditorView.updateImages();
//                       display.displayMainScreen();
//
//                }
                       display.displayMainScreen();

            }
        });

        options.addActionListener(e -> {
		    MapEditorSystem mapEditor = new MapEditorSystem(display);
		    mapEditor.start();
		    mapEditor.setVisible( true );
		    display.setVisible( false );
		});

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

}
