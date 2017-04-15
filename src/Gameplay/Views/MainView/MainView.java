package Gameplay.Views.MainView;

import Gameplay.Views.Display;
import Gameplay.Views.ScreenSelectButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JPanel {
    ScreenSelectButtons screenSelectBtns;
    Display display;

    public MainView(Display display) {
        this.display = display;
        screenSelectBtns = new ScreenSelectButtons();
        this.add(screenSelectBtns);
        addCustomListenersToScreenSelectBtns();
        setBackground( new Color( 0xff9de7d7 ) );
        setVisible(true);
    }

    public void addCustomListenersToScreenSelectBtns() {

       screenSelectBtns.addListnerToMainScreenButton( new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               display.setCurrScreen("MAIN_SCREEN");
           }
       } );
        screenSelectBtns.addListnerToWonderScreenButton( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setCurrScreen("WONDER_SCREEN");
            }
        } );
        screenSelectBtns.addListnerToResearchScreenButton( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setCurrScreen("RESEARCH_SCREEN");
            }
        } );
        screenSelectBtns.addListnerToTransporterScreenButton( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setCurrScreen("TRANSPORTER_SCREEN");
            }
        } );

    }

}
