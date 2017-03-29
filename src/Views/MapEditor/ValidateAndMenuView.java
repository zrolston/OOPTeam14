package Views.MapEditor;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Model.ModelFacade;
import Views.Utility.ImageLoader;
import Views.Utility.PixelMap;

public class ValidateAndMenuView extends JPanel {
	ButtonPanelView buttonPanel;
	JLabel validateLabel;
	
	public ValidateAndMenuView(ButtonPanelView buttonPanel) {
		this.buttonPanel = buttonPanel;
		setLayout(new GridLayout(0,2));
		
        setBounds((int)(PixelMap.SCREEN_WIDTH*17.7/20), PixelMap.SCREEN_HEIGHT/40, PixelMap.SCREEN_WIDTH/10, (int)(buttonPanel.getBounds().getY() - PixelMap.SCREEN_HEIGHT/40));
        setOpaque(false);
        
        validateLabel = new JLabel(new ImageIcon(ImageLoader.getImage("SAD_CAT")));
        validateLabel.setBackground(Color.red);
        validateLabel.setOpaque(true);
        validateLabel.setFocusable(false);
        validateLabel.setBorder(new LineBorder(Color.BLACK));
        
        JButton hamburgerButton = new JButton(new ImageIcon(ImageLoader.getImage("HAMBURGER")));
        hamburgerButton.setOpaque(true);
        hamburgerButton.setFocusable(false);
        hamburgerButton.addActionListener(e -> {
			buttonPanel.toggle();
		});
        hamburgerButton.setBorder(new LineBorder(Color.BLACK));
        
        this.add(validateLabel);
        this.add(hamburgerButton);
	}

	public void checkValidation() {
		ModelFacade model = ModelFacade.getInstance();
        if (model.validateMap()) {
        	validateLabel.setIcon(new ImageIcon(ImageLoader.getImage("HAPPY_CAT")));
        	validateLabel.setBackground(Color.green);
        } else {
        	validateLabel.setIcon(new ImageIcon(ImageLoader.getImage("SAD_CAT")));
        	validateLabel.setBackground(Color.red);
        }
	}
}
