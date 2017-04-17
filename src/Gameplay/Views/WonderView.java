package Gameplay.Views;

import javax.swing.*;

import MapBuilder.Views.Utility.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

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
		//These below are tests of the circle on top of wonder
		drawCircle(g, 4, "ORANGE", x, y, width, height);
		drawCircle(g, 5, "BLUE", x, y, width, height);

		g.drawImage(wonder, x, y, width, height, null);

		//These are tests of wonder bricks
		//drawBrick(g, position (0-61), "BLUE", x, y, width, height);
		//drawBrick(g, position (0-61), "ORANGE", x, y, width, height);
		//drawBrick(g, position (0-61), "NEUTRAL", x, y, width, height);
		//drawBrick(g, 0, "BLUE", x, y, width, height);
		//drawBrick(g, 1, "WHITE", x, y, width, height);
		//drawBrick(g, 2, "ORANGE", x, y, width, height);
		//drawBrick(g, 61, "WHITE", x, y, width, height);
	}

	private void drawCircle(Graphics g, int position, String color, int x, int y, int width, int height) {
		BufferedImage marker = ImageLoader.getImage(color + "_MARKER");
		double scale = (double)width/(double)819;
		int xPosition = (x + (int)(width/9.42) + (int)(width/9.4 * position));
		int yPosition = (y + (int)(height * (0.017)));
		int markerWidth = (int)(marker.getWidth() * scale);
		int markerHeight = (int)(marker.getHeight() * scale);
		g.drawImage(marker, xPosition, yPosition, markerWidth, markerHeight, null);
	}

	private void drawBrick(Graphics g, int position, String color, int x, int y, int width, int height) {
		int level = 0; //This is the level from the bottom of the wonder that the brick is on
		int brickX = 0;
		double scale = (double)width/(double)819;
		if (position <= 11) {
			level = position / 4;
			brickX = (x + (int)(width/3.45) + (int)(width/9.4 * (position % 4)));
		} else if (position <= 31) {
			level = ((position - 12) / 5) + 3;
			brickX = (x + (int)(width/4.18) + (int)(width/9.4 * ((position - 12) % 5)));
		} else {
			level = ((position - 32) / 6) + 7;
			brickX = (x + (int)(width/5.52) + (int)(width/9.4 * ((position - 32) % 6)));
		}
		int brickY = (y + (int)(height * (0.85 - (level * 0.051))));
		BufferedImage brick = ImageLoader.getImage(color + "_BRICK");
		int brickWidth = (int)(brick.getWidth() * scale);
		int brickHeight = (int)(brick.getHeight() * scale);
		g.drawImage(brick, brickX, brickY, brickWidth, brickHeight, null);
	}

	public void addCustomListenersToScreenSelectBtns() {
		screenSelectBtns.addListnerToMainScreenButton( e -> display.displayMainScreen() );
		screenSelectBtns.addListnerToWonderScreenButton( e -> display.displayWonderScreen() );
		screenSelectBtns.addListnerToResearchScreenButton( e -> display.displayResearchScreen() );
		screenSelectBtns.addListnerToTransporterScreenButton( e -> display.displayTransporterScreen() );
	}

}