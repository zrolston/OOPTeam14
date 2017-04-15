package Gameplay.Views;

import javax.swing.*;

import MapBuilder.Views.Utility.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ResearchView extends JPanel {
	BufferedImage research = ImageLoader.getImage("RESEARCH_TABLE");
	BufferedImage researchMarker = ImageLoader.getImage("RESEARCH_MARKER");
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
    	
    	//This is a test of the first three researches researched.
    	drawMarker(g, 0, x, y, width, height);
    	drawMarker(g, 1, x, y, width, height);
    	drawMarker(g, 2, x, y, width, height);
    }
    
    private void drawMarker(Graphics g, int position, int x, int y, int width, int height) {
    	BufferedImage marker = ImageLoader.getImage("RESEARCH_MARKER");
    	double scale = (double)width/(double)1048;
    	int xPosition = (x + (int)(width/45) + (int)(width/8.5 * position));
    	int yPosition = (y + (int)(height * (0.09)));
    	int markerWidth = (int)(marker.getWidth() * scale);
    	int markerHeight = (int)(marker.getHeight() * scale);
    	g.drawImage(marker, xPosition, yPosition, markerWidth, markerHeight, null);
    }
    
    public void addCustomListenersToScreenSelectBtns() {
        screenSelectBtns.addListnerToMainScreenButton( e -> display.setCurrScreen("MAIN_SCREEN") );
        screenSelectBtns.addListnerToWonderScreenButton( e -> display.setCurrScreen("WONDER_SCREEN") );
        screenSelectBtns.addListnerToResearchScreenButton( e -> display.setCurrScreen("RESEARCH_SCREEN") );
        screenSelectBtns.addListnerToTransporterScreenButton( e -> display.setCurrScreen("TRANSPORTER_SCREEN") );
    }

}
