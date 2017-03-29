package Views.MapEditor;

import Controllers.ButtonListener.LoadButtonListener;
import Controllers.ButtonListener.SaveButtonListener;
import Controllers.ButtonListener.ValidateButtonListener;
import Controllers.ButtonListener.ClearButtonListener;
import Views.MapEditor.MapView.MapSubsectionView;
import Views.Utility.ImageLoader;
import Views.Utility.PixelMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Willie on 3/28/2017.
 */
public class ButtonPanelView extends JPanel {

    BufferedImage panelBackground = null;

    public ButtonPanelView(MapSubsectionView mapSubsectionView) {
        setLayout(new GridLayout(3, 0));
        setBounds((int)(PixelMap.SCREEN_WIDTH*18.6981/20), (int)(PixelMap.SCREEN_HEIGHT/10.8), PixelMap.SCREEN_WIDTH/20, PixelMap.SCREEN_HEIGHT / 4);
        panelBackground = ImageLoader.getImage("PANEL_BACKGROUND");

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Serif", Font.BOLD, 8));
        saveButton.setBackground( new Color( 0xffCABD80 ) );
        saveButton.setOpaque(false);
        saveButton.setFocusable(false);
        saveButton.addActionListener(new SaveButtonListener());
        saveButton.setOpaque( true );
        this.setOpaque( true );

        JButton loadButton = new JButton("Load");
        loadButton.setBackground(new Color( 0xffCABD80 ));
        loadButton.setOpaque(false);
        loadButton.setFocusable(false);
        loadButton.addActionListener(new LoadButtonListener(mapSubsectionView));
        loadButton.setFont(new Font("Serif", Font.BOLD, 8));

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color( 0xffCABD80 ));
        clearButton.setOpaque(false);
        clearButton.setFocusable(false);
        clearButton.addActionListener(new ClearButtonListener(mapSubsectionView));
        clearButton.setFont(new Font("Serif", Font.BOLD, 8));


        this.add(saveButton);
        this.add(loadButton);
        this.add(clearButton);

        this.setBackground( new Color( 0xffCABD80 )   );

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
