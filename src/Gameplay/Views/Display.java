package Gameplay.Views;

import Gameplay.Views.HomeView.HomeView;
import Gameplay.Views.MainView.MainView;
import MapBuilder.Views.Utility.PixelMap;

import javax.swing.*;

public class Display extends JFrame{

    private MainView mainScreen;
    private HomeView homeScreen;
    private WonderView wonderScreen;
    private ResearchView researchScreen;
    private TransporterView transporterScreen;

    public Display() {

        setTitle("Roads & Boats");
        setSize( PixelMap.SCREEN_WIDTH, PixelMap.SCREEN_HEIGHT );

        mainScreen = new MainView( this );
        homeScreen = new HomeView( this );
        wonderScreen = new WonderView( this );
        researchScreen = new ResearchView( this );
        transporterScreen = new TransporterView( this );

        displayHomeScreen();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void displayHomeScreen() {
        getContentPane().removeAll();   // clear screen
        this.getContentPane().add( homeScreen );
        revalidate();
        repaint();
    }
    public void displayMainScreen() {
        getContentPane().removeAll();   // clear screen
        this.getContentPane().add( mainScreen );
        revalidate();
        repaint();
    }
    public void displayWonderScreen() {
        getContentPane().removeAll();   // clear screen
        this.getContentPane().add( wonderScreen );
        revalidate();
        repaint();
    }
    public void displayResearchScreen() {
        getContentPane().removeAll();   // clear screen
        this.getContentPane().add( researchScreen );
        revalidate();
        repaint();
    }
    public void displayTransporterScreen() {
        getContentPane().removeAll();   // clear screen
        this.getContentPane().add( transporterScreen );
        revalidate();
        repaint();
    }

    public MainView getMainView(){
        return mainScreen;
    }
}
