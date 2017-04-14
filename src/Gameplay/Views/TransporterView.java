package Gameplay.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransporterView extends JPanel {

    ScreenSelectButtons screenSelectBtns;
    Display display;

    public TransporterView(Display display) {
        this.display = display;
        screenSelectBtns = new ScreenSelectButtons();
        this.add(screenSelectBtns);
        addCustomListenersToScreenSelectBtns();
        setBackground( new Color( 0xfffcaebb ) );
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
