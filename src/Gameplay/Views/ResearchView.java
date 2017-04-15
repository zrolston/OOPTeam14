package Gameplay.Views;

import javax.swing.*;

import MapBuilder.Views.Utility.ImageLoader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ResearchView extends JPanel {
	BufferedImage research = ImageLoader.getImage("RESEARCH_TABLE");
	BufferedImage researchBackground = ImageLoader.getImage("RESEARCH_BACKGROUND");
    ScreenSelectButtons screenSelectBtns;
    Display display;

    public ResearchView(Display display) {
        this.display = display;
        screenSelectBtns = new ScreenSelectButtons();
        this.add(screenSelectBtns);
        addCustomListenersToScreenSelectBtns();
        setBackground( new Color( 0xffffd700 ) );
        setVisible(true);
    }

    
    @Override
    public void paintComponent(Graphics g) {
    	((Graphics2D)(g)).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    	int height = (int)(getHeight() * 0.4);
    	int width = (1048 * height)/254;
    	int x = getWidth()/2 - width/2;
    	int y = (int)(getHeight() * 0.3);
    	g.drawImage(researchBackground, 0 , 0, getWidth(), getHeight(), null);
    	g.drawImage(research, x, y, width, height, null);
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
