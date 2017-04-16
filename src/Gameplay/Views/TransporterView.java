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
        screenSelectBtns.addListnerToMainScreenButton( e -> display.displayMainScreen() );
        screenSelectBtns.addListnerToWonderScreenButton( e -> display.displayWonderScreen() );
        screenSelectBtns.addListnerToResearchScreenButton( e -> display.displayResearchScreen() );
        screenSelectBtns.addListnerToTransporterScreenButton( e -> display.displayTransporterScreen() );
    }

}
