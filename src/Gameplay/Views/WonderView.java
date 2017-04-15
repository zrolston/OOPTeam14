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
	BufferedImage blueBrick = ImageLoader.getImage("BLUE_BRICK");
	BufferedImage orangeBrick = ImageLoader.getImage("ORANGE_BRICK");
	BufferedImage neutralBrick = ImageLoader.getImage("NEUTRAL_BRICK");
    ScreenSelectButtons screenSelectBtns;
    Display display;

    public WonderView(Display display) {
        this.display = display;
        screenSelectBtns = new ScreenSelectButtons();
        this.add(screenSelectBtns);
        addCustomListenersToScreenSelectBtns();
        setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	((Graphics2D)(g)).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    	
    	int height = (int)(getHeight() * 0.85);
    	int width = (819 * height)/901;
    	int x = getWidth()/2 - width/2;
    	int y = (int)(getHeight() * 0.1);
    	g.drawImage(wonderBackground, 0 , 0, getWidth(), getHeight(), null);
    	g.drawImage(wonder, x, y, width, height, null);
    	drawBrick(g, 1, (double)width/(double)819);
    }

    private void drawBrick(Graphics g, int position, double scale) {
    	int x = 500;
    	int y = 500;
    	
    	g.drawImage(blueBrick, x, y, (int)(blueBrick.getWidth() * scale), (int)(blueBrick.getHeight() * scale), null);
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
