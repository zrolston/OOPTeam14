package Gameplay.Views;

import javax.swing.*;
import java.awt.*;

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
        screenSelectBtns.addListnerToMainScreenButton( e -> display.setCurrScreen("MAIN_SCREEN") );
        screenSelectBtns.addListnerToWonderScreenButton( e -> display.setCurrScreen("WONDER_SCREEN") );
        screenSelectBtns.addListnerToResearchScreenButton( e -> display.setCurrScreen("RESEARCH_SCREEN") );
        screenSelectBtns.addListnerToTransporterScreenButton( e -> display.setCurrScreen("TRANSPORTER_SCREEN") );
    }

}
