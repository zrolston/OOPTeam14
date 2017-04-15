package Gameplay.Views;

import javax.swing.*;

import MapBuilder.Views.Utility.ImageLoader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class WonderView extends JPanel {
	BufferedImage wonder = ImageLoader.getImage("WONDER");
	BufferedImage wonderBackground = ImageLoader.getImage("WONDER_BACKGROUND");
    ScreenSelectButtons screenSelectBtns;
    Display display;

    public WonderView(Display display) {
        this.display = display;
        screenSelectBtns = new ScreenSelectButtons();
        this.add(screenSelectBtns);
        addCustomListenersToScreenSelectBtns();
        setBackground( new Color( 0xffa7e163 ) );
        setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	((Graphics2D)(g)).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    	int height = (int)(getHeight() * 0.85);
    	int width = (834 * height)/906;
    	g.drawImage(wonderBackground, 0 , 0, getWidth(), getHeight(), null);
    	g.drawImage(wonder, this.getWidth()/2 - width/2 , (int)(getHeight() * 0.1), width, height, null);
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
