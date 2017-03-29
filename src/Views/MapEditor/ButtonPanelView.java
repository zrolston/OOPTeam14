package Views.MapEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controllers.ButtonListener.ClearButtonListener;
import Controllers.ButtonListener.LoadButtonListener;
import Controllers.ButtonListener.SaveButtonListener;
import Views.MapEditor.MapView.MapSubsectionView;
import Views.Utility.ImageLoader;
import Views.Utility.PixelMap;

/**
 * Created by Willie on 3/28/2017.
 */
public class ButtonPanelView extends JPanel {
	private BufferedImage bomb;
	private BufferedImage loadImage;
	private BufferedImage saveImage;
    private BufferedImage panelBackground;

    public ButtonPanelView(MapSubsectionView mapSubsectionView, MapEditorView mapEditorView) {
        setLayout(new GridLayout(3, 0));
        setBounds((int)(PixelMap.SCREEN_WIDTH*18.6981/20), (int)(PixelMap.SCREEN_HEIGHT/10.8), PixelMap.SCREEN_WIDTH/20, PixelMap.SCREEN_HEIGHT / 4);
        panelBackground = ImageLoader.getImage("PANEL_BACKGROUND");
        loadImage = ImageLoader.getImage("LOAD");
        saveImage = ImageLoader.getImage("SAVE");
        bomb = ImageLoader.getImage("BOMB");
        
        JButton saveButton = new JButton(new ImageIcon(saveImage));
        saveButton.setFont(new Font("Serif", Font.BOLD, 8));
        saveButton.setBackground( new Color( 0xffCABD80 ) );
        saveButton.setOpaque(false);
        saveButton.setFocusable(false);
        saveButton.addActionListener(new SaveButtonListener());
        saveButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton loadButton = new JButton(new ImageIcon(loadImage));
        loadButton.setBackground( new Color( 0xffCABD80 )  );
        loadButton.setOpaque(false);
        loadButton.setFocusable(false);
        loadButton.addActionListener(new LoadButtonListener(mapSubsectionView, mapEditorView));
        loadButton.setFont(new Font("Serif", Font.BOLD, 8));
        loadButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JButton clearButton = new JButton(new ImageIcon(bomb));
        clearButton.setBackground(new Color( 0xffCABD80 )  );
        clearButton.setOpaque(false);
        clearButton.setFocusable(false);
        clearButton.addActionListener(new ClearButtonListener(mapSubsectionView, mapEditorView));
        clearButton.setFont(new Font("Serif", Font.BOLD, 8));
        clearButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setOpaque(true);
        this.add(saveButton);
        this.add(loadButton);
        this.add(clearButton);

        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(panelBackground, 0, 0, (int)(getWidth() * 2), (int)(getHeight() * 2), null);
    }

	public void toggle() {
		if (isVisible()) {
			setVisible(false);
		} else {
			setVisible(true);
		}
	}

}
