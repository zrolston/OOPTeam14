package Gameplay.Views;

import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;

import static MapBuilder.Views.Utility.PixelMap.*;


public class Display extends JFrame{

    private MainView mainScreen;
    private PreGameView homeScreen;
    private WonderView wonderScreen;
    private ResearchView researchScreen;
    private TransporterView transporterScreen;

    public Display() {

        setTitle("Roads & Boats");
        setSize( PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT );

        mainScreen = new MainView(this);
        homeScreen = new PreGameView( this );
        wonderScreen = new WonderView(this);
        researchScreen = new ResearchView(this);
        transporterScreen = new TransporterView(this);

        setCurrScreen( "HOME_SCREEN" );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setCurrScreen(String selected_screen) {

        getContentPane().removeAll();   // clear screen

        switch (selected_screen) {
            case "HOME_SCREEN":
                displayHomeScreen();
                break;
            case "MAIN_SCREEN":
                displayMainScreen();
                break;
            case "WONDER_SCREEN":
                displayWonderScreen();
                break;
            case "RESEARCH_SCREEN":
                displayResearchScreen();
                break;
            case "TRANSPORTER_SCREEN":
                displayTransporterScreen();
                break;
        }

        revalidate();
        repaint();
    }

    private void displayHomeScreen() {
        this.getContentPane().add( homeScreen );
    }
    private void displayMainScreen() {
        this.getContentPane().add( mainScreen );
    }
    private void displayWonderScreen() {
        this.getContentPane().add( wonderScreen );
    }
    private void displayResearchScreen() {
        this.getContentPane().add( researchScreen );
    }
    private void displayTransporterScreen() {
        this.getContentPane().add( transporterScreen );
    }

}
