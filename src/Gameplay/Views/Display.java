package Gameplay.Views;

import Gameplay.Views.HomeView.HomeView;
import Gameplay.Views.MainView.MainView;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;

/**
 * Created by Thomas on 4/13/17.
 */
public class Display extends JFrame{

    private MainView mainScreen;
    private HomeView homeScreen;
    private WonderView wonderScreen;
    private ResearchView researchScreen;
    private TransporterView transporterScreen;

    public Display() {

        setTitle("Roads & Boats");
        setSize( PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT );

        mainScreen = new MainView();
        homeScreen = new HomeView( this );
        wonderScreen = new WonderView();
        researchScreen = new ResearchView();
        transporterScreen = new TransporterView();

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
